package ru.itmo.diplomaairline.model.dto.partial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

/**
 * Дто человека без id
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HumanDtoWithoutId {
    @NotBlank(message = "Фамилия не должна быть пустой")
    private String surname;
    @NotBlank(message = "Имя не должно быть пустыми")
    private String name;
    private String lastName;
    @NotNull(message = "День рождения не должен быть пустым")
    private LocalDate birthDate;
    @NotNull(message = "Документ не должен быть пустым")
    private DocumentDtoWithoutId document;
}
