package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.TicketMapper;
import ru.itmo.diplomaairline.model.dto.full.FullTicketDto;
import ru.itmo.diplomaairline.model.entity.Ticket;
import ru.itmo.diplomaairline.repository.TicketRepository;
import ru.itmo.diplomaairline.service.data.TicketService;

import java.util.List;
import java.util.Objects;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.TicketService}
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public FullTicketDto getTicketById(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Ticket.class, id));
        return ticketMapper.ticketToFullDto(ticket);
    }

    @Override
    public List<FullTicketDto> getAllTicketsByUserId(Long id) {
        List<Ticket> tickets = ticketRepository.findAllByHumanId(id);
        return tickets.stream()
                .filter(x -> x.getHuman() != null && Objects.equals(x.getHuman().getId(), id))
                .map(x -> ticketMapper.ticketToFullDto(x)).toList();
    }

    @Override
    public List<FullTicketDto> getAllTicketsByFlightId(Long id) {
        List<Ticket> tickets = ticketRepository.findAllByFlightId(id);
        return tickets.stream()
                .map(x -> ticketMapper.ticketToFullDto(x)).toList();
    }

    @Override
    public FullTicketDto saveTicket(FullTicketDto ticket) {
        return ticketMapper.ticketToFullDto(
                ticketRepository.save(ticketMapper.fullDtoToTicket(ticket))
        );
    }

    @Override
    public Integer saveAllTickets(List<FullTicketDto> tickets) {
        return ticketRepository.saveAll(
                tickets.stream()
                        .map(x -> ticketMapper.fullDtoToTicket(x))
                        .toList())
                .size();
    }
}
