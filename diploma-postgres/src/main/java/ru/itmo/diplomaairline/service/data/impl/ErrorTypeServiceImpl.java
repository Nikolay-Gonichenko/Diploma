package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.ErrorTypeMapper;
import ru.itmo.diplomaairline.model.dto.full.FullErrorTypeDto;
import ru.itmo.diplomaairline.model.entity.ErrorType;
import ru.itmo.diplomaairline.repository.ErrorTypeRepository;
import ru.itmo.diplomaairline.service.data.ErrorTypeService;

/**
 * реализация {@link ru.itmo.diplomaairline.service.data.ErrorTypeService}
 */
@Service
public class ErrorTypeServiceImpl implements ErrorTypeService {
    @Autowired
    private ErrorTypeMapper errorTypeMapper;
    @Autowired
    private ErrorTypeRepository errorTypeRepository;


    @Override
    public FullErrorTypeDto getErrorTypeById(Long id) {
        ErrorType errorType = errorTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(ErrorType.class, id));
        return errorTypeMapper.errorTypeToFullDto(errorType);
    }
}
