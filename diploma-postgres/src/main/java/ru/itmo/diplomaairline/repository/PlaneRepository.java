package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Plane;

/**
 * Репозиторий сущности Самолёт
 */
@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {
}
