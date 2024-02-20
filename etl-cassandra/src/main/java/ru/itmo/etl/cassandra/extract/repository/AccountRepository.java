package ru.itmo.etl.cassandra.extract.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itmo.etl.cassandra.extract.model.Account;

/**
 * Репозиторий сущности "Аккаунт пользователя"
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account getAccountByNickname(String nickname);

    Account getAccountByNicknameAndPassword(String nickname, String password);
}
