package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Human;

/**
 * Репозиторий сущности "Человек"
 */
@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
}
