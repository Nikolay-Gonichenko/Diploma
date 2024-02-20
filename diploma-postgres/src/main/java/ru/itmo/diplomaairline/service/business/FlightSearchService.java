package ru.itmo.diplomaairline.service.business;

import ru.itmo.diplomaairline.model.dto.full.FullFlightDto;
import ru.itmo.diplomaairline.model.dto.partial.FlightSearchDto;

import java.util.List;

/**
 * Сервис для поиска полетов по фильтрам
 */
public interface FlightSearchService {

    /**
     * Получение всех полетов по фильтрам
     * @param search дто фильтров поиска
     * @return список полетов удовлетворяющих фильтрам
     */
    List<FullFlightDto> getFlightsByFilters(FlightSearchDto search);
}
