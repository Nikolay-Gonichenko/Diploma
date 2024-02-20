package ru.itmo.diplomaairline.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Полное дто полёта
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullFlightDto {
    private Long id;
    private LocalDate dateStart;
    private LocalDate dateFinish;
    private FullFlightStatusDto flightStatus;
    private FullPlaneDto plane;
    private FullRouteDto route;
}
