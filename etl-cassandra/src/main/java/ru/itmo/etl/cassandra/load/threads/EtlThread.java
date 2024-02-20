package ru.itmo.etl.cassandra.load.threads;

import lombok.RequiredArgsConstructor;
import ru.itmo.etl.cassandra.extract.model.Ticket;
import ru.itmo.etl.cassandra.service.CassandraEtlService;

import java.util.List;

@RequiredArgsConstructor
public class EtlThread implements Runnable {

    private final CassandraEtlService cassandraEtlService;
    private List<Ticket> tickets;

    @Override
    public void run()  {
        cassandraEtlService.startEtl(tickets);
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
