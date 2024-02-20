package ru.itmo.diplomaairline.service.business;

import ru.itmo.diplomaairline.model.dto.full.FullRouteDto;

import java.util.List;

/**
 * Сервис для работы с рекомендациями
 */
public interface RecommendationService {

    /**
     * Получение рекомендованных маршрутов для пользователя
     * @param id идентификатор пользователя
     * @param count количество необходимых рекомендаций
     * @return список рекомендованных маршрутов
     */
    List<FullRouteDto> getRecommendationsToUser(long id, int count);
}
