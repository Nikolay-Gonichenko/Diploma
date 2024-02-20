package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullAccountDto;
import ru.itmo.diplomaairline.model.entity.Account;

/**
 * Маппер аккаунта
 */
@Mapper(componentModel = "spring", uses = {HumanMapper.class, RoleMapper.class})
public interface AccountMapper {

    FullAccountDto accountToFullDto(Account account);

    Account fullDtoToAccount(FullAccountDto accountD);
}
