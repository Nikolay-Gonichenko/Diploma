package ru.itmo.etl.cassandra.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.etl.cassandra.extract.model.Ticket;
import ru.itmo.etl.cassandra.load.model.FLightsHumansCost;
import ru.itmo.etl.cassandra.load.model.pk.FLightsHumansCostPK;
import ru.itmo.etl.cassandra.load.repository.FLightsHumansCostRepository;
import ru.itmo.etl.cassandra.load.util.TicketUtil;
import ru.itmo.etl.cassandra.service.CassandraEtlService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("fLightsHumansCostService")
public class FLightsHumansCostService implements CassandraEtlService {

    private final FLightsHumansCostRepository fLightsHumansCostRepository;
    private final TicketUtil ticketUtil;

    @Override
    @Transactional
    public void startEtl(List<Ticket> tickets) {
        System.out.println("Данные пришли в fLightsHumansCostService");

        var entities = tickets.stream()
                .map(ticket -> FLightsHumansCost
                        .builder()
                        .fLightsHumansCostPK(FLightsHumansCostPK
                                .builder()
                                .flight(ticket.getFlight().getId())
                                .human(ticket.getHuman().getId())
                                .cost(ticket.getCost())
                                .build())
                        .dateStart(ticket.getFlight().getDateStart())
                        .dateFinish(ticket.getFlight().getDateFinish())
                        .humanAge(ticketUtil.getAgeFromTicket(ticket))
                        .placeFrom(ticketUtil.getLocationName(ticket.getFlight()
                                .getRoute().getFromLocation()))
                        .placeTo(ticketUtil.getLocationName(ticket.getFlight()
                                .getRoute().getToLocation()))
                        .build()
                )
                .toList();

        fLightsHumansCostRepository.saveAll(entities);


        System.out.println("Загрузка данных в fLightsHumansCostService окончена.");
    }
}
