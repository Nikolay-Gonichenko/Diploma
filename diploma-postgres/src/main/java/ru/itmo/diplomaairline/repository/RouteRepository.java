package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Route;

/**
 * Репозиторий сущности Маршрут
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
}
