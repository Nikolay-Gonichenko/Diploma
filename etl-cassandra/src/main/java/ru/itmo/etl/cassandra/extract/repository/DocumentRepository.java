package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Document;

/**
 * Репозиторий сущности "Документ"
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
