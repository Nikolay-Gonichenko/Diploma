package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Option;

/**
 * Репозиторий сущности "Дополнительная услуга"
 */
@Repository
public interface OptionRepository extends JpaRepository<Option, Long> {
}
