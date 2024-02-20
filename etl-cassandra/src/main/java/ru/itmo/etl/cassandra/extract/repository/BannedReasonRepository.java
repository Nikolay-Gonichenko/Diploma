package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.BannedReason;

/**
 * Репозиторий сущности "Причина блокировки пользователя"
 */
@Repository
public interface BannedReasonRepository extends JpaRepository<BannedReason, Long> {
}
