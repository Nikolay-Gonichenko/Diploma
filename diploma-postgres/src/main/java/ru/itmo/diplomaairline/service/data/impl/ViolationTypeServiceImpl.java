package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.ViolationTypeMapper;
import ru.itmo.diplomaairline.model.dto.full.FullViolationTypeDto;
import ru.itmo.diplomaairline.model.entity.ViolationType;
import ru.itmo.diplomaairline.repository.ViolationTypeRepository;
import ru.itmo.diplomaairline.service.data.ViolationTypeService;

/**
 * Реализация {@link ViolationTypeService}
 */
@Service
public class ViolationTypeServiceImpl implements ViolationTypeService {

    @Autowired
    private ViolationTypeRepository violationTypeRepository;
    @Autowired
    private ViolationTypeMapper violationTypeMapper;

    @Override
    public FullViolationTypeDto getViolationTypeById(Long id) {
        ViolationType violationType = violationTypeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(ViolationType.class, id));
        return violationTypeMapper.violationTypeToFullDto(violationType);
    }
}
