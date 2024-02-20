package ru.itmo.diplomaairline.service.business;

import ru.itmo.diplomaairline.model.dto.partial.ShortTicketDto;

/**
 * Сервис для управления покупкой и ценами билетов
 */
public interface TicketOperationService {

    /**
     * Покупка билета пользователем
     * @param humanId идентификатор пользователя
     * @param ticket краткое дто билета с данными пользоателя
     * @return идентификатор купленного билета
     */
    Long buyTicket(Long humanId, ShortTicketDto ticket);

    /**
     * Назначение цены билетам на полет
     * @param flightId идентификатор полета
     * @return количество билетов, для которых изменена цена
     */
    Integer setCostOnTickets(Long flightId, Integer cost);
}
