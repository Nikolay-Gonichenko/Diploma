package ru.itmo.diplomaairline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.diplomaairline.model.entity.Account;

/**
 * Репозиторий сущности "Аккаунт пользователя"
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByNickname(String nickname);

    Account getAccountByNicknameAndPassword(String nickname, String password);
}
