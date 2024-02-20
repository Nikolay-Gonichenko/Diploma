package ru.itmo.etl.cassandra.load.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.load.model.FLightsHumansCost;
import ru.itmo.etl.cassandra.load.model.pk.FLightsHumansCostPK;

@Repository
public interface FLightsHumansCostRepository extends CassandraRepository<FLightsHumansCost, FLightsHumansCostPK> {
}
