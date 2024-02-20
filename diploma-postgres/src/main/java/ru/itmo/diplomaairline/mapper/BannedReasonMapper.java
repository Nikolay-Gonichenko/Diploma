package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullBannedReasonDto;
import ru.itmo.diplomaairline.model.entity.BannedReason;

/**
 * Маппер причины блокировки пользователя
 */
@Mapper(componentModel = "spring")
public interface BannedReasonMapper {
    FullBannedReasonDto bannedReasonToFullDto(BannedReason bannedReason);
}
