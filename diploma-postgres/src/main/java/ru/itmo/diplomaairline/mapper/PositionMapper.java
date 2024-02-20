package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullPositionDto;
import ru.itmo.diplomaairline.model.entity.Position;

/**
 * Маппер для должности работника
 */
@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface PositionMapper {
    FullPositionDto positionToFullDto(Position position);
}
