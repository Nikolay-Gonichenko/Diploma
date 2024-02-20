package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Error;

/**
 * Репозиторий сущности "Ошибка"
 */
@Repository
public interface ErrorRepository extends JpaRepository<Error, Long> {
}
