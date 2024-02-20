package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Error;

/**
 * Репозиторий сущности "Ошибка"
 */
@Repository
public interface ErrorRepository extends JpaRepository<Error, Long> {
}
