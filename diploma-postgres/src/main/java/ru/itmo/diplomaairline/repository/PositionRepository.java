package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Position;

/**
 * Репозиторий сущности "Позиция"
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
}
