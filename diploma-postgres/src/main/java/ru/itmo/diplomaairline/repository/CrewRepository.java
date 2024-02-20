package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Crew;
import ru.itmo.diplomaairline.model.entity.pk.CrewPk;

/**
 * Репозиторий сущности "Экипаж судна"
 */
@Repository
public interface CrewRepository extends JpaRepository<Crew, CrewPk> {
}
