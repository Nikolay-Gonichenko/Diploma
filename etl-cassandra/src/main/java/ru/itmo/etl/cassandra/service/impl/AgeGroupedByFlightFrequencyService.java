package ru.itmo.etl.cassandra.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.etl.cassandra.extract.model.Ticket;
import ru.itmo.etl.cassandra.load.model.AgeGroupedByFlightFrequency;
import ru.itmo.etl.cassandra.load.model.pk.AgeGroupedByFlightFrequencyPK;
import ru.itmo.etl.cassandra.load.repository.AgeGroupedByFlightFrequencyRepository;
import ru.itmo.etl.cassandra.load.util.TicketUtil;
import ru.itmo.etl.cassandra.service.CassandraEtlService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Qualifier("ageGroupedByFlightFrequencyService")
public class AgeGroupedByFlightFrequencyService implements CassandraEtlService {

    private final AgeGroupedByFlightFrequencyRepository ageGroupedByFlightFrequencyRepository;
    private final TicketUtil ticketUtil;

    private final Map<AgeGroupedByFlightFrequencyPK, Integer> map = new HashMap();

    @Override
    @Transactional
    public void startEtl(List<Ticket> tickets) {
        System.out.println("Данные пришли в ageGroupedByFlightFrequencyService");

        tickets.stream()
                .map(ticket -> new AgeGroupedByFlightFrequencyPK(
                    ticketUtil.getAgeFromTicket(ticket),
                    ticketUtil.getRouteStrFromRoute(ticket.getFlight().getRoute()),
                    ticketUtil.getMonthFromDate(ticket.getFlight().getDateStart())
                ))
                .forEach(value -> {
                    if (map.containsKey(value)) {
                        map.put(value, map.get(value) + 1);
                    } else {
                        map.put(value, 1);
                    }
                });

        var entities = map.keySet()
                .stream()
                .map(key -> new AgeGroupedByFlightFrequency(key, map.get(key)))
                .toList();

        ageGroupedByFlightFrequencyRepository.saveAll(entities);

        System.out.println("Загрузка данных в ageGroupedByFlightFrequencyService окончена.");
    }
}
