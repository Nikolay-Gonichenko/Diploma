package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullHumanDto;
import ru.itmo.diplomaairline.model.entity.Human;

/**
 * Маппер человека
 */
@Mapper(componentModel = "spring", uses = {DocumentMapper.class})
public interface HumanMapper {
    FullHumanDto humanToFullDto(Human human);
}
