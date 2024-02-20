package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Role;

/**
 * Репозиторий сущности "Роль"
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
