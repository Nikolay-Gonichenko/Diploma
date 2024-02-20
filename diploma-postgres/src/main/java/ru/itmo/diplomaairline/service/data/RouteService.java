package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullRouteDto;

/**
 * Сервис для работы с сущностью маршрута
 */
public interface RouteService {

    /**
     * Получение маршрута по его id
     * @param id идентификатор маршрута
     * @return полное дто маршрута
     */
    FullRouteDto getRouteById(Long id);
}
