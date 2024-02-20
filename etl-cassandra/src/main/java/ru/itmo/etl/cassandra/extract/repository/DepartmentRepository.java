package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Department;

/**
 * Репозиторий сущности "Департамент"
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
