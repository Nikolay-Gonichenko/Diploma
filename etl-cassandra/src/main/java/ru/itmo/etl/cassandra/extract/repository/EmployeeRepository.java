package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Employee;

/**
 * Репозиторий сущности "Работник авиакомпании"
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
