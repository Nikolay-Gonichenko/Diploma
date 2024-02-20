package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Plane;

/**
 * Репозиторий сущности Самолёт
 */
@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
