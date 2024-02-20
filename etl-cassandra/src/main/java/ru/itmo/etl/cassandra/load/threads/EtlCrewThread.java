package ru.itmo.etl.cassandra.load.threads;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.itmo.etl.cassandra.extract.model.Crew;
import ru.itmo.etl.cassandra.service.impl.ProfitFlightsService;

import java.util.List;

@RequiredArgsConstructor
@Setter
public class EtlCrewThread implements Runnable {
    private final ProfitFlightsService profitFlightsService;
    private List<Crew> crews;

    @Override
    public void run() {

        profitFlightsService.startEtl(crews);
    }
}
