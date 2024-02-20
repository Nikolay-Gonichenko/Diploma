package ru.itmo.etl.cassandra.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itmo.etl.cassandra.extract.model.Option;
import ru.itmo.etl.cassandra.load.model.OptionsByFlightsTime;
import ru.itmo.etl.cassandra.load.model.pk.OptionsByFlightsTimePK;
import ru.itmo.etl.cassandra.load.repository.OptionsByFlightsTimeRepository;
import ru.itmo.etl.cassandra.load.util.TicketUtil;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("optionsByFlightsTimeService")
public class OptionsByFlightsTimeService {

    private final OptionsByFlightsTimeRepository optionsByFlightsTimeRepository;
    private final TicketUtil ticketUtil;

    @Transactional
    public void startEtl(List<Option> options) {
        System.out.println("Данные пришли в optionsByFlightsTimeService");
        if (options == null || options.isEmpty()) {
            System.out.println("Options кончились");
            return;
        }

        var entities = options.stream()
                .map(option -> {
                    var ticket = option.getTicket();
                    var flight = ticket.getFlight();
                    var human = ticket.getHuman();
                    var locationTo = flight.getRoute().getToLocation();
                    var locationFrom = flight.getRoute().getFromLocation();
                    return OptionsByFlightsTime
                                    .builder()
                                    .optionsByFlightsTimePK(OptionsByFlightsTimePK
                                            .builder()
                                            .flight(flight.getId())
                                            .human(human.getId())
                                            .option(option.getId())
                                            .flightTime(ticketUtil.getFlightTime(flight))
                                            .build())
                                    .dateStart(flight.getDateStart())
                                    .dateFinish(flight.getDateFinish())
                                    .humanAge(ticketUtil.getAgeFromTicket(ticket))
                                    .optionName(option.getOptionType().getName())
                                    .airportTo(locationTo.getAirport())
                                    .countryTo(locationTo.getCountry())
                                    .cityTo(locationTo.getCity())
                                    .airportFrom(locationFrom.getAirport())
                                    .countryFrom(locationFrom.getCountry())
                                    .cityFrom(locationFrom.getCity())
                                    .build();
                    }
                ).toList();

        optionsByFlightsTimeRepository.saveAll(entities);

        System.out.println("Загрузка данных в optionsByFlightsTimeService окончена.");
    }
}
