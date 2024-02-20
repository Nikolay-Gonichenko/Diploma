package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullBannedListDto;
import ru.itmo.diplomaairline.model.entity.BannedList;

/**
 * Мапер для работы с блокировкой пользователя
 */
@Mapper(componentModel = "spring", uses = {HumanMapper.class, BannedReasonMapper.class})
public interface BannedListMapper {
    BannedList fullDtoToBannedList(FullBannedListDto fullBannedListDto);
}
