package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullErrorDto;
import ru.itmo.diplomaairline.model.entity.Error;

/**
 * Мапер для сущности ошикби
 */
@Mapper(componentModel = "spring")
public interface ErrorMapper {
    Error fullDtoToError(FullErrorDto fullErrorDto);
}
