package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullFlightStatusDto;
import ru.itmo.diplomaairline.model.entity.FlightStatus;

/**
 * Маппер статуса полета
 */
@Mapper(componentModel = "spring")
public interface FlightStatusMapper {

    FullFlightStatusDto flightStatusToFullDto(FlightStatus flightStatus);
}
