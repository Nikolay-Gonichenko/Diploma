package ru.itmo.etl.cassandra.service;

import ru.itmo.etl.cassandra.extract.model.Ticket;

import java.util.List;

public interface CassandraEtlService {

    void startEtl(List<Ticket> tickets);
}
