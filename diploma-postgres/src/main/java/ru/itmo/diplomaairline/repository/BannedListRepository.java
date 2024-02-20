package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.BannedList;

/**
 * Репозиторий сущности "Заблокированные пользователи"
 */
@Repository
public interface BannedListRepository extends JpaRepository<BannedList, Long> {
}
