package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.DocumentType;

/**
 * Репозиторий сущности "Тип документа"
 */
@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
