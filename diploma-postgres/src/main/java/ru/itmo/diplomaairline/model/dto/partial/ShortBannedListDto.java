package ru.itmo.diplomaairline.model.dto.partial;

import jakarta.validation.constraints.NotNull;

/**
 * Краткое дто для бана человека
 */
public record ShortBannedListDto(
        @NotNull(message = "ИД причины не должен быть пустым") Long reasonId,
        @NotNull(message = "ИД человека не должен быть пустым") Long humanId) {
}
