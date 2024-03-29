package ru.itmo.diplomaairline.model.dto.partial;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

/**
 * Краткое дто полета
 */
public record ShortFlightDto(
        @NotNull(message = "Дата начала полёта не должна быть пустой") LocalDate dateStart,
        @NotNull(message = "Дата конца полёта не должна быть пустой") LocalDate dateFinish,
        @NotNull(message = "Статус полёта не должен быть пустой") Long flightStatus,
        @NotNull(message = "ИД самолёта полёта не должен быть пустой") Long plane,
        @NotNull(message = "ИД маршрута не должен быть пустой") Long route) {

}
