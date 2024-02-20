package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.FlightStatus;

/**
 * Репозиторий сущности "Статус полёта"
 */
@Repository
public interface FlightStatusRepository extends JpaRepository<FlightStatus, Long> {
}
