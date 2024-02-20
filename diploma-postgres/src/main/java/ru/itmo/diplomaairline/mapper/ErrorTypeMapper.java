package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullErrorTypeDto;
import ru.itmo.diplomaairline.model.entity.ErrorType;

/**
 * Мапер типа ошибки
 */
@Mapper(componentModel = "spring")
public interface ErrorTypeMapper {
    FullErrorTypeDto errorTypeToFullDto(ErrorType errorType);
}
