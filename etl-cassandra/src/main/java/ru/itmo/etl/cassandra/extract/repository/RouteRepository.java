package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Route;

/**
 * Репозиторий сущности Маршрут
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
