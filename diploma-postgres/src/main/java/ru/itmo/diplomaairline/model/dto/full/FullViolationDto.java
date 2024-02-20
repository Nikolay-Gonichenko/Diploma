package ru.itmo.diplomaairline.model.dto.full;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Полное дто нарушения
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullViolationDto {
    private Long id;
    private FullAccountDto account;
    private FullViolationTypeDto violationType;
    private LocalDate date;
    private String message;
}
