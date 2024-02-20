package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullViolationDto;

/**
 * Сервис для работы с сущностью нарушения
 */
public interface ViolationService {

    /**
     * Сохраняет новое нарушение
     * @param violationDto полное дто нарушения
     */
    void saveViolation(FullViolationDto violationDto);
}
