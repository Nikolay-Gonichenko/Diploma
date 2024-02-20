package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullFlightDto;
import ru.itmo.diplomaairline.model.entity.Flight;

/**
 * Маппер полётов
 */
@Mapper(componentModel = "spring")
public interface FlightMapper {
    FullFlightDto flightToFullDto(Flight flight);

    Flight fullDtoToFlight(FullFlightDto flightDto);
}
