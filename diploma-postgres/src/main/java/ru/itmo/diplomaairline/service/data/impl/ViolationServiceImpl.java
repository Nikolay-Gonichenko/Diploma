package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.mapper.ViolationMapper;
import ru.itmo.diplomaairline.model.dto.full.FullViolationDto;
import ru.itmo.diplomaairline.repository.ViolationRepository;
import ru.itmo.diplomaairline.service.data.ViolationService;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.ViolationService}
 */
@Service
public class ViolationServiceImpl implements ViolationService {
    @Autowired
    private ViolationRepository violationRepository;
    @Autowired
    private ViolationMapper violationMapper;

    @Override
    public void saveViolation(FullViolationDto violationDto) {
        violationRepository.save(violationMapper.fullDtoToViolation(violationDto));
    }
}
