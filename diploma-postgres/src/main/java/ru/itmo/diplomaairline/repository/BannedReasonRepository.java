package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.BannedReason;

/**
 * Репозиторий сущности "Причина блокировки пользователя"
 */
@Repository
public interface BannedReasonRepository extends JpaRepository<BannedReason, Long> {
}
