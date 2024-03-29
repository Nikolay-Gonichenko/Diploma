package ru.itmo.diplomaairline.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.diplomaairline.model.dto.partial.ShortCrewDto;
import ru.itmo.diplomaairline.service.business.CrewManagementService;

/**
 * Контроллер для управления экипажом корабля
 */
@RestController
@RequestMapping("api/v1/airline/crew")
public class CrewManagementController {

    @Autowired
    private CrewManagementService crewManagementService;

    /**
     * Добавление работника на полёт
     * @param crewDto краткое дто
     * @return true если операция завершилась успешно
     */
    @PostMapping("add")
    public ResponseEntity<Boolean> addEmployeeToFlight(@Valid @RequestBody ShortCrewDto crewDto) {
        return ResponseEntity.ok(crewManagementService.addEmployeeToFlight(crewDto));
    }
}
