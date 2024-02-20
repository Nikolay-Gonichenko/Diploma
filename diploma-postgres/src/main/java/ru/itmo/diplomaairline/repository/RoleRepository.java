package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Role;

/**
 * Репозиторий сущности "Роль"
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
