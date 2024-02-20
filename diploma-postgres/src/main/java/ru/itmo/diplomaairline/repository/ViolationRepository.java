package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Violation;

/**
 * Репозиторий сущности "Нарушение"
 */
@Repository
public interface ViolationRepository extends JpaRepository<Violation, Long> {
}
