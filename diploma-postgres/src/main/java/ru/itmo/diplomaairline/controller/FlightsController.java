package ru.itmo.diplomaairline.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.diplomaairline.model.dto.full.FullFlightDto;
import ru.itmo.diplomaairline.model.dto.partial.FlightSearchDto;
import ru.itmo.diplomaairline.service.business.FlightSearchService;

import java.util.List;

/**
 * Контроллер для работы с полетами
 * */
@RestController
@RequestMapping("api/v1/airline/flights")
public class FlightsController {

    @Autowired
    private FlightSearchService flightSearchService;

    @PostMapping("all")
    public ResponseEntity<List<FullFlightDto>> getFlights(@Valid @RequestBody FlightSearchDto search) {
        return ResponseEntity.ok(flightSearchService.getFlightsByFilters(search));
    }
}
