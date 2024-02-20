package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullDocumentDto;
import ru.itmo.diplomaairline.model.entity.Document;

/**
 * Маппер документов
 */
@Mapper(componentModel = "spring", uses = {DocumentTypeMapper.class})
public interface DocumentMapper {

    FullDocumentDto documentToFullDto(Document document);
}
