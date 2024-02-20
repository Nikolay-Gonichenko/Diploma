package ru.itmo.diplomaairline.service.business;

import ru.itmo.diplomaairline.model.dto.partial.AccountDtoForLogin;

/**
 * Сервис для входа пользователя в систему
 */
public interface LoginService {

    /**
     * Вход в систему
     * @param accountDtoForLogin логин и пароль пользователя
     * @return токен
     */
    String login(AccountDtoForLogin accountDtoForLogin);
}
