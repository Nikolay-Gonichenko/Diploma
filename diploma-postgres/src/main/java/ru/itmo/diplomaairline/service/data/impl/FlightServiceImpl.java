package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.FlightMapper;
import ru.itmo.diplomaairline.model.dto.full.FullFlightDto;
import ru.itmo.diplomaairline.model.entity.Flight;
import ru.itmo.diplomaairline.repository.FlightRepository;
import ru.itmo.diplomaairline.service.data.FlightService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.FlightService}
 */
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FullFlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Flight.class, id));
        return flightMapper.flightToFullDto(flight);
    }

    @Override
    public List<FullFlightDto> getAllFlights(Integer offset, Integer limit) {
        List<Flight> flights = flightRepository.findAll(PageRequest.of(offset, limit)).stream().toList();
        return flights.stream().map(x -> flightMapper.flightToFullDto(x)).collect(Collectors.toList());
    }

    @Override
    public FullFlightDto saveFlight(FullFlightDto flight) {
        return flightMapper.flightToFullDto(
                flightRepository.save(flightMapper.fullDtoToFlight(flight))
        );
    }
}
