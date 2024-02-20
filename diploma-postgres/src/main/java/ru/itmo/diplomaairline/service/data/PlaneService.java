package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullPlaneDto;

/**
 * Сервис для работы с сущностью самолета
 */
public interface PlaneService {

    /**
     * Получение дто самолета по id
     * @param id идентификатор самолета
     * @return дто самолета
     */
    FullPlaneDto getPlaneById(Long id);
}
