package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.FlightStatusMapper;
import ru.itmo.diplomaairline.model.dto.full.FullFlightStatusDto;
import ru.itmo.diplomaairline.model.entity.FlightStatus;
import ru.itmo.diplomaairline.repository.FlightStatusRepository;
import ru.itmo.diplomaairline.service.data.FlightStatusService;

@Service
public class FlightStatusServiceImpl implements FlightStatusService {

    @Autowired
    FlightStatusMapper flightStatusMapper;
    @Autowired
    FlightStatusRepository flightStatusRepository;
    @Override
    public FullFlightStatusDto getFlightStatusById(Long id) {
        FlightStatus flightStatus = flightStatusRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(FlightStatus.class, id));
        return flightStatusMapper.flightStatusToFullDto(flightStatus);
    }
}
