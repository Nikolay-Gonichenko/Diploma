package ru.itmo.diplomaairline.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Полное дто работника
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullEmployeeDto {
    private Long id;
    private FullAccountDto account;
    private LocalDate employmentDate;
    private FullPositionDto position;
    private Integer salary;
}
