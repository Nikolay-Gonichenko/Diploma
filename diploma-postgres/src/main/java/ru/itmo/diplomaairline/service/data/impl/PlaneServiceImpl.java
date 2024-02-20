package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.PlaneMapper;
import ru.itmo.diplomaairline.model.dto.full.FullPlaneDto;
import ru.itmo.diplomaairline.model.entity.Plane;
import ru.itmo.diplomaairline.repository.PlaneRepository;
import ru.itmo.diplomaairline.service.data.PlaneService;

/**
 * реализация {@link PlaneService}
 */
@Service
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    PlaneMapper planeMapper;
    @Autowired
    PlaneRepository planeRepository;
    @Override
    public FullPlaneDto getPlaneById(Long id) {
        Plane plane = planeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Plane.class, id));
        return planeMapper.planeToFullDto(plane);
    }
}
