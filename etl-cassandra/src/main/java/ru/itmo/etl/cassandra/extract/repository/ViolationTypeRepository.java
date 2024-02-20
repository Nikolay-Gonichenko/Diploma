package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.ViolationType;

/**
 * Репозиторий сущности "Тип нарушения"
 */
@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Long> {
}
