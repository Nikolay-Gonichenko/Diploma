package ru.itmo.diplomaairline.service.business;

import ru.itmo.diplomaairline.model.dto.partial.ShortCrewDto;

/**
 * Сервис для работы с экипажем судна
 */
public interface CrewManagementService {

    /**
     * Добавление работника на рейс
     * @param crewDto краткое дто
     * @return true если операция завершилась успешно
     */
    Boolean addEmployeeToFlight(ShortCrewDto crewDto);
}
