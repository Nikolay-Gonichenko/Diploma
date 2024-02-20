package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.ViolationType;

/**
 * Репозиторий сущности "Тип нарушения"
 */
@Repository
public interface ViolationTypeRepository extends JpaRepository<ViolationType, Long> {
}
