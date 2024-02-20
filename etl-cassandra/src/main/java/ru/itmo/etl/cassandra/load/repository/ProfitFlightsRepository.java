package ru.itmo.etl.cassandra.load.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.load.model.ProfitFlights;
import ru.itmo.etl.cassandra.load.model.pk.ProfitFlightsPK;

@Repository
public interface ProfitFlightsRepository extends CassandraRepository<ProfitFlights, ProfitFlightsPK> {
}
