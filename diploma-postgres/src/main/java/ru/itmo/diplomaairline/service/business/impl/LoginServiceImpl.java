package ru.itmo.diplomaairline.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.buisiness.WrongCredentialsException;
import ru.itmo.diplomaairline.model.dto.full.FullAccountDto;
import ru.itmo.diplomaairline.model.dto.partial.AccountDtoForLogin;
import ru.itmo.diplomaairline.service.business.LoginService;
import ru.itmo.diplomaairline.service.data.AccountService;

/**
 * реализация {@link ru.itmo.diplomaairline.service.business.LoginService}
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AccountService accountService;


    @Override
    public String login(AccountDtoForLogin accountDtoForLogin) {
        FullAccountDto fullAccountDto = accountService.getAccountByNickname(accountDtoForLogin.getNickname());
       if (fullAccountDto == null || !accountDtoForLogin.getPassword().equals(fullAccountDto.getPassword()))
            throw new WrongCredentialsException(accountDtoForLogin);
        return "token";
    }
}
