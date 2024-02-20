package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullPlaneDto;
import ru.itmo.diplomaairline.model.entity.Plane;

/**
 * Маппер самолета
 */
@Mapper(componentModel = "spring")
public interface PlaneMapper {
    FullPlaneDto planeToFullDto(Plane plane);
}
