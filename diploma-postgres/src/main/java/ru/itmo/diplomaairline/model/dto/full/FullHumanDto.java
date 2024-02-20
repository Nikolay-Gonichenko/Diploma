package ru.itmo.diplomaairline.model.dto.full;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Полное дто человека
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullHumanDto {
    private Long id;
    private String surname;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private FullDocumentDto document;
}
