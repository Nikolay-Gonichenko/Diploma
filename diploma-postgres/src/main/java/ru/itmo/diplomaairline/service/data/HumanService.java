package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullHumanDto;

/**
 * Сервис для работы с сущностью человека
 */
public interface HumanService {

    /**
     * Получение человека по его id
     * @param id идентификатор человека
     * @return полное дто человека
     */
    FullHumanDto getHumanById(Long id);
}
