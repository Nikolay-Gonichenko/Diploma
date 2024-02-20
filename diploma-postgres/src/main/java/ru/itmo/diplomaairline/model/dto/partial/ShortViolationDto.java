package ru.itmo.diplomaairline.model.dto.partial;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

/**
 * Краткое дто нарушения
 */
public record ShortViolationDto(
        @NotNull(message = "ИД аккаунта не должен быть пустой") Long accountId,
        @NotNull(message = "ИД причины блокировки не должен быть пустой") Long typeId,
        @NotNull(message = "Дата не должна быть пустой") LocalDate date,
        @NotBlank(message = "Сообщение не должно быть пустым") String message) {
}
