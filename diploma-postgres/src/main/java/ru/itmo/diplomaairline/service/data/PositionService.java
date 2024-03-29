package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullPositionDto;

/**
 * Сервис для работы с сущностью Должность
 */
public interface PositionService {

    /**
     * Получение должности по id
     * @param id идентификатор должности
     * @return полное дто должности
     */
    FullPositionDto getPositionById(Long id);
}
