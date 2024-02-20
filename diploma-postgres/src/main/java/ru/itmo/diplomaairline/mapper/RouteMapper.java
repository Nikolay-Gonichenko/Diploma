package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullRouteDto;
import ru.itmo.diplomaairline.model.entity.Route;

/**
 * Маппер маршрута
 */
@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface RouteMapper {
    FullRouteDto routeToFullDto(Route route);
}
