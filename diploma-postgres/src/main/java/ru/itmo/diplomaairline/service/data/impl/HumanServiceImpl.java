package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.HumanMapper;
import ru.itmo.diplomaairline.model.dto.full.FullHumanDto;
import ru.itmo.diplomaairline.model.entity.Human;
import ru.itmo.diplomaairline.repository.HumanRepository;
import ru.itmo.diplomaairline.service.data.HumanService;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.HumanService}
 */
@Service
public class HumanServiceImpl implements HumanService {

    @Autowired
    private HumanRepository humanRepository;
    @Autowired
    private HumanMapper humanMapper;

    @Override
    public FullHumanDto getHumanById(Long id) {
        Human human = humanRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Human.class, id));
        return humanMapper.humanToFullDto(human);
    }
}
