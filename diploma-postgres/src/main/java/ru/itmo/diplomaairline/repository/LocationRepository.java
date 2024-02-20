package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Location;

/**
 * Репозиторий сущности Локация
 */
@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
