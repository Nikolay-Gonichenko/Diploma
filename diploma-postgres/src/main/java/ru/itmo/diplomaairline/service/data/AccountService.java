package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullAccountDto;

/**
 * Сервис для работы с сущностью аккаунта
 */
public interface AccountService {

    /**
     * Получение аккаунта по id
     * @param id идентификатор аккаунта
     * @return дто аккаунта
     */
    FullAccountDto getAccountById(Long id);

    /**
     * Сохраняет новый аккаунт
     * @param account полное дто аккаунта
     * @return полное дто аккаунта с id
     */
    FullAccountDto saveAccount(FullAccountDto account);

    /**
     * Проверяет существование аккаунта
     * @param login логин
     * @param password пароль
     * @return true если такой аккаунт есть
     */
    boolean isExistAccountByNicknameAndPassword(String login, String password);

    /**
     * Получает аккаунт по никнейму
     * @param nickname никнейм
     * @return никнейм
     */
    FullAccountDto getAccountByNickname(String nickname);
}
