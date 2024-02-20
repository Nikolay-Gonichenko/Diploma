package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullDocumentTypeDto;
import ru.itmo.diplomaairline.model.entity.DocumentType;

/**
 * Мапер типа документа
 */
@Mapper(componentModel = "spring")
public interface DocumentTypeMapper {

    FullDocumentTypeDto documentTypeToFullDto(DocumentType documentType);
}
