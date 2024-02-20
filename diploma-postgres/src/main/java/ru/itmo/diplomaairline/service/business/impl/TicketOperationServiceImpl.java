package ru.itmo.diplomaairline.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.buisiness.IncorrectMoneyAmountException;
import ru.itmo.diplomaairline.exception.buisiness.NotFoundEmptyTicketForPlaceException;
import ru.itmo.diplomaairline.model.dto.full.FullTicketDto;
import ru.itmo.diplomaairline.model.dto.partial.ShortTicketDto;
import ru.itmo.diplomaairline.service.business.TicketOperationService;
import ru.itmo.diplomaairline.service.data.HumanService;
import ru.itmo.diplomaairline.service.data.TicketService;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Реализация {@link TicketOperationService}
 */
@Service
public class TicketOperationServiceImpl implements TicketOperationService {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private HumanService humanService;

    @Override
    public Long buyTicket(Long humanId, ShortTicketDto ticket) {
        FullTicketDto ticketDto = ticketService.getAllTicketsByFlightId(ticket.flight())
                .stream()
                .filter(x -> x.getHuman() == null && Objects.equals(x.getPlace(), ticket.place()))
                .findFirst()
                .orElseThrow(() -> new NotFoundEmptyTicketForPlaceException(ticket.flight(), ticket.place()));
        if (ticket.cost() != ticketDto.getCost()) {
            throw new IncorrectMoneyAmountException(ticketDto.getCost(), ticket.cost());
        }
        ticketDto.setHuman(humanService.getHumanById(humanId));
        return ticketService.saveTicket(ticketDto).getId();
    }

    @Override
    public Integer setCostOnTickets(Long flightId, Integer cost) {
        List<FullTicketDto> flightTickets = ticketService.getAllTicketsByFlightId(flightId);
        List<FullTicketDto> newTickets = new LinkedList<>();
        for (FullTicketDto current : flightTickets) {
            current.setCost(cost);
            newTickets.add(current);
        }
        return ticketService.saveAllTickets(newTickets);
    }
}
