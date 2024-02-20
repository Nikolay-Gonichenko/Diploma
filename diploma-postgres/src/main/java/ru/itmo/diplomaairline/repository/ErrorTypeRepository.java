package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.ErrorType;

/**
 * Репозиторий сущности "Тип ошибки"
 */
@Repository
public interface ErrorTypeRepository extends JpaRepository<ErrorType, Long> {
}
