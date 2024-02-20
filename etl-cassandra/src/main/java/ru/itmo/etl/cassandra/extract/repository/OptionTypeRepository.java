package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.OptionType;

/**
 * Репозиторий сущности "Дополнительная услуга"
 */
@Repository
public interface OptionTypeRepository extends JpaRepository<OptionType, Long> {
}
