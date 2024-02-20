package ru.itmo.etl.cassandra.load.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.load.model.ProfitableFlightsRoutes;
import ru.itmo.etl.cassandra.load.model.pk.ProfitableFlightsRoutesPK;

@Repository
public interface ProfitableFlightsRoutesRepository
        extends CassandraRepository<ProfitableFlightsRoutes, ProfitableFlightsRoutesPK> {
}
