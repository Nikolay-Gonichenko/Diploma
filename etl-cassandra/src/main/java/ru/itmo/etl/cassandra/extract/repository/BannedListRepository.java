package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.BannedList;

/**
 * Репозиторий сущности "Заблокированные пользователи"
 */
@Repository
public interface BannedListRepository extends JpaRepository<BannedList, Long> {
}
