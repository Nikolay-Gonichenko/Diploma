package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullViolationTypeDto;
import ru.itmo.diplomaairline.model.entity.ViolationType;

/**
 * Маппер для работы с типами нарушений
 */
@Mapper(componentModel = "spring")
public interface ViolationTypeMapper {

    FullViolationTypeDto violationTypeToFullDto(ViolationType violationType);
}
