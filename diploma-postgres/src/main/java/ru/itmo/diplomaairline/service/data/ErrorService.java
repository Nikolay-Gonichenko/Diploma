package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullErrorDto;

/**
 * Сервис для работы с сущностью ошибки
 */
public interface ErrorService {
    /**
     * Сохранение ошибки
     *
     * @param fullErrorDto полное дто ошибки
     */
    void saveError(FullErrorDto fullErrorDto);
}
