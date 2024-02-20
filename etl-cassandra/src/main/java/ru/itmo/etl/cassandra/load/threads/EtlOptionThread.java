package ru.itmo.etl.cassandra.load.threads;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.itmo.etl.cassandra.extract.model.Option;
import ru.itmo.etl.cassandra.service.impl.OptionsByFlightsTimeService;

import java.util.List;

@RequiredArgsConstructor
@Setter
public class EtlOptionThread implements Runnable {

    private final OptionsByFlightsTimeService optionsByFlightsTimeService;
    private List<Option> options;

    @Override
    public void run() {
        optionsByFlightsTimeService.startEtl(options);
    }
}
