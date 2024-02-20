package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Document;

/**
 * Репозиторий сущности "Документ"
 */
@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
