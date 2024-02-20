package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.mapper.CrewMapper;
import ru.itmo.diplomaairline.model.dto.full.FullCrewDto;
import ru.itmo.diplomaairline.repository.CrewRepository;
import ru.itmo.diplomaairline.service.data.CrewService;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.CrewService}
 */
@Service
public class CrewServiceImpl implements CrewService {
    @Autowired
    private CrewRepository crewRepository;
    @Autowired
    private CrewMapper crewMapper;

    @Override
    public Boolean saveCrew(FullCrewDto crewDto) {
        crewRepository.save(crewMapper.fullDtoToCrew(crewDto));
        return true;
    }
}
