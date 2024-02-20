package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullLocationDto;
import ru.itmo.diplomaairline.model.entity.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    FullLocationDto locationToFullDto(Location location);
}
