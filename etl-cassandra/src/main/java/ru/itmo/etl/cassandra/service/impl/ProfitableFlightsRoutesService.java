package ru.itmo.etl.cassandra.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.etl.cassandra.extract.model.Employee;
import ru.itmo.etl.cassandra.extract.model.Flight;
import ru.itmo.etl.cassandra.extract.model.Ticket;
import ru.itmo.etl.cassandra.load.model.ProfitableFlightsRoutes;
import ru.itmo.etl.cassandra.load.model.pk.ProfitableFlightsRoutesPK;
import ru.itmo.etl.cassandra.load.repository.ProfitableFlightsRoutesRepository;
import ru.itmo.etl.cassandra.load.util.TicketUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("profitableFlightsRoutesService")
public class ProfitableFlightsRoutesService {

    private final ProfitableFlightsRoutesRepository profitableFlightsRoutesRepository;
    private final TicketUtil ticketUtil;

    @Transactional
    public void startEtl(List<Flight> flights) {
        System.out.println("Данные пришли в profitableFlightsRoutesService");

        var entities = flights.stream()
                .map(flight -> {
                    var route = flight.getRoute();
                    var totalCost = 0.0;
                    for (Ticket ticket : flight.getTickets()) {
                        totalCost += ticket.getCost();
                    }
                    var totalExpense = 0.0;
                    for (Employee employee: flight.getEmployees()) {
                        totalExpense += (employee.getSalary() / 168.0);
                    }
                    return ProfitableFlightsRoutes
                            .builder()
                            .profitableFlightsRoutesPK(ProfitableFlightsRoutesPK
                                    .builder()
                                    .flight(flight.getId())
                                    .route(route.getId())
                                    .dateTime(flight.getDateStart())
                                    .cleanProfit(totalCost -  totalExpense)
                                    .build())
                            .placeTo(ticketUtil.getLocationName(route.getToLocation()))
                            .placeFrom(ticketUtil.getLocationName(route.getFromLocation()))
                            .totalCost(totalCost)
                            .totalExpense(totalExpense)
                            .planeModel(flight.getPlane().getModel())
                            .build();
                })
                .toList();

        profitableFlightsRoutesRepository.saveAll(entities);

        System.out.println("Загрузка данных в profitableFlightsRoutesService окончена.");
    }
}
