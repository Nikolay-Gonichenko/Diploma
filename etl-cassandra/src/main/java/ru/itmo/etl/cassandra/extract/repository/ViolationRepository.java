package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Violation;

/**
 * Репозиторий сущности "Нарушение"
 */
@Repository
public interface ViolationRepository extends JpaRepository<Violation, Long> {
}
