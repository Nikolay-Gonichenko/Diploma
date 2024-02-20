package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Human;

/**
 * Репозиторий сущности "Человек"
 */
@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
}
