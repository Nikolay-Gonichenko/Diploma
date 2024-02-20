package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullTicketDto;
import ru.itmo.diplomaairline.model.entity.Ticket;

@Mapper(componentModel = "spring", uses = {FlightMapper.class, HumanMapper.class})
public interface TicketMapper {

    FullTicketDto ticketToFullDto(Ticket ticket);

    Ticket fullDtoToTicket(FullTicketDto ticketDto);
}
