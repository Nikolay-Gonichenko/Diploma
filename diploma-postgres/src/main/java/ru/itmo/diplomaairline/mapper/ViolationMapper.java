package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullViolationDto;
import ru.itmo.diplomaairline.model.entity.Violation;

/**
 * Маппер для работы с нарушениями пользователей
 */
@Mapper(componentModel = "spring", uses = {AccountMapper.class})
public interface ViolationMapper {

    Violation fullDtoToViolation(FullViolationDto fullViolationDto);
}
