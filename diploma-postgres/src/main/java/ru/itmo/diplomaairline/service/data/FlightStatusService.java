package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullFlightStatusDto;

/**
 * Сервис для работы с сущностью статуса полёта
 */
public interface FlightStatusService {

    /**
     * Получение статуса полёта по id
     * @param id идентификатор статуса полёта
     * @return дто статуса полёта
     */
    FullFlightStatusDto getFlightStatusById(Long id);
}
