package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Position;

/**
 * Репозиторий сущности "Позиция"
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
