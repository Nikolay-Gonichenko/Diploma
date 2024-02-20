package ru.itmo.etl.cassandra.load.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.load.model.OptionsByFlightsTime;
import ru.itmo.etl.cassandra.load.model.pk.OptionsByFlightsTimePK;

@Repository
public interface OptionsByFlightsTimeRepository
        extends CassandraRepository<OptionsByFlightsTime, OptionsByFlightsTimePK> {
}
