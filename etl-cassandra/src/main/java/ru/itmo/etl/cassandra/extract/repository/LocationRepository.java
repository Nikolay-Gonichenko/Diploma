package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Location;

/**
 * Репозиторий сущности Локация
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
