package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Crew;
import ru.itmo.etl.cassandra.extract.model.Flight;
import ru.itmo.etl.cassandra.extract.model.pk.CrewPk;

import java.util.List;

/**
 * Репозиторий сущности "Экипаж судна"
 */
@Repository
public interface CrewRepository extends JpaRepository<Crew, CrewPk> {
    List<Crew> findAllByCrewPk_Flight(Flight flight);
}
