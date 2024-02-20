package ru.itmo.etl.cassandra.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.etl.cassandra.extract.model.Crew;
import ru.itmo.etl.cassandra.load.model.ProfitFlights;
import ru.itmo.etl.cassandra.load.model.pk.ProfitFlightsPK;
import ru.itmo.etl.cassandra.load.repository.ProfitFlightsRepository;
import ru.itmo.etl.cassandra.load.util.TicketUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("profitFlightsService")
public class ProfitFlightsService {

    private final ProfitFlightsRepository profitFlightsRepository;
    private final TicketUtil ticketUtil;

    @Transactional
    public void startEtl(List<Crew> crews) {
        System.out.println("Данные пришли в profitFlightsService");
        if (crews == null || crews.isEmpty()) {
            System.out.println("Crews кончились");
            return;
        }

        var entities = crews.stream()
                .map(crew -> {
                    var flight = crew.getCrewPk().getFlight();
                    var route = flight.getRoute();
                    var employee = crew.getCrewPk().getEmployee();
                    var position  = employee.getPosition();

                    return ProfitFlights
                            .builder()
                            .profitFlightsPK(ProfitFlightsPK
                                    .builder()
                                    .flight(flight.getId())
                                    .employee(employee.getId())
                                    .route(route.getId())
                                    .build())
                            .dateStart(flight.getDateStart())
                            .dateFinish(flight.getDateFinish())
                            .flightTime(ticketUtil.getFlightTime(flight))
                            .routeName(ticketUtil.getRouteStrFromRoute(route))
                            .workTime(ticketUtil.getWorkTime(employee, flight))
                            .positionId(position.getId())
                            .positionName(position.getName())
                            .employeeSalary((double) (employee.getSalary() / 168))
                            .build();
                })
                .toList();

        profitFlightsRepository.saveAll(entities);

        System.out.println("Загрузка данных в profitFlightsService окончена.");
    }
}
