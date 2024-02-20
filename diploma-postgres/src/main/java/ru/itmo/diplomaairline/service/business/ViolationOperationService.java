package ru.itmo.diplomaairline.service.business;

import ru.itmo.diplomaairline.model.dto.partial.ShortBannedListDto;
import ru.itmo.diplomaairline.model.dto.partial.ShortViolationDto;

/**
 * Сервис для работы с нарушениями пользователей
 */
public interface ViolationOperationService {

    /**
     * Добавляет нарушение к аккаунту
     * @param violationDto краткое описание нарушения
     * @return обновлённое количество нарушений
     */
    Integer addViolation(ShortViolationDto violationDto);

    /**
     * Блокирует пользователя на сайте компании
     * @param bannedListDto краткое дто
     * @return true если операция прошла успешно
     */
    Boolean ban(ShortBannedListDto bannedListDto);
}


