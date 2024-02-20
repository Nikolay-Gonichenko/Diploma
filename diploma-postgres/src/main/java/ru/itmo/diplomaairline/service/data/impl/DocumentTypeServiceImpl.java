package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.DocumentTypeMapper;
import ru.itmo.diplomaairline.model.dto.full.FullDocumentTypeDto;
import ru.itmo.diplomaairline.model.entity.DocumentType;
import ru.itmo.diplomaairline.repository.DocumentTypeRepository;
import ru.itmo.diplomaairline.service.data.DocumentTypeService;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.DocumentTypeService}
 */
@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private DocumentTypeMapper documentTypeMapper;


    @Override
    public FullDocumentTypeDto getDocumentTypeById(Long id) {
        DocumentType documentType = documentTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(DocumentType.class, id));
        return documentTypeMapper.documentTypeToFullDto(documentType);
    }
}
