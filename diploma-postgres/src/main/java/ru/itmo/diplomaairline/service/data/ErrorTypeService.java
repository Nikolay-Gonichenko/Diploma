package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullErrorTypeDto;

/**
 * Сервис для работы с типами ошибок
 */
public interface ErrorTypeService {

    /**
     * Получение типа ошибки по id
     * @param id идентификатор типа ошибки
     * @return полное дто типа ошибки
     */
    FullErrorTypeDto getErrorTypeById(Long id);
}
