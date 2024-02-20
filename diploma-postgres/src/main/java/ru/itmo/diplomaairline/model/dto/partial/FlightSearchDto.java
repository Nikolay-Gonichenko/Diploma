package ru.itmo.diplomaairline.model.dto.partial;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Полное дто для описания фильров по полетам
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightSearchDto {
    @NotNull(message = "Локации не должны быть пустыми")
    private Long fromLocation;
    @NotNull(message = "Локации не должны быть пустыми")
    private Long toLocation;
    private LocalDate Start = null;
    private boolean isNeedBack;
}
