package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Department;

/**
 * Репозиторий сущности "Департамент"
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
