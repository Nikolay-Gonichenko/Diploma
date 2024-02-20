package ru.itmo.etl.cassandra.load.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.load.model.AgeGroupedByFlightFrequency;
import ru.itmo.etl.cassandra.load.model.pk.AgeGroupedByFlightFrequencyPK;

@Repository
public interface AgeGroupedByFlightFrequencyRepository
        extends CassandraRepository<AgeGroupedByFlightFrequency, AgeGroupedByFlightFrequencyPK> {
}
