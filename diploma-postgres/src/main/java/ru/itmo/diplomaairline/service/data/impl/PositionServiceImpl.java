package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.PositionMapper;
import ru.itmo.diplomaairline.model.dto.full.FullPositionDto;
import ru.itmo.diplomaairline.model.entity.Position;
import ru.itmo.diplomaairline.repository.PositionRepository;
import ru.itmo.diplomaairline.service.data.PositionService;

/**
 * Реализация {@link PositionService}
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public FullPositionDto getPositionById(Long id) {
        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Position.class, id));
        return positionMapper.positionToFullDto(position);
    }
}
