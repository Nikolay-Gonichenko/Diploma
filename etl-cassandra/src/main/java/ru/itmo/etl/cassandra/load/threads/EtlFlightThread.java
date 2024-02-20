package ru.itmo.etl.cassandra.load.threads;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import ru.itmo.etl.cassandra.extract.model.Flight;
import ru.itmo.etl.cassandra.service.impl.ProfitableFlightsRoutesService;

import java.util.List;

@RequiredArgsConstructor
@Setter
public class EtlFlightThread implements Runnable {
    private final ProfitableFlightsRoutesService profitableFlightsRoutesService;
    private List<Flight> flights;

    @Override
    public void run() {
        profitableFlightsRoutesService.startEtl(flights);
    }
}
