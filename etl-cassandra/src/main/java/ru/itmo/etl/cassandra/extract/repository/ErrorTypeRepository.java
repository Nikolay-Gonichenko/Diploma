package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.ErrorType;

/**
 * Репозиторий сущности "Тип ошибки"
 */
@Repository
public interface ErrorTypeRepository extends JpaRepository<ErrorType, Long> {
}
