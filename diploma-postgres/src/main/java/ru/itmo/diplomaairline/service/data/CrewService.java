package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullCrewDto;

/**
 * Сервис для работы с сущностью экипажа
 */
public interface CrewService {

    /**
     * Сохранение экипажа
     * @param crewDto полное дто экипажа
     */
    Boolean saveCrew(FullCrewDto crewDto);
}
