package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.mapper.ErrorMapper;
import ru.itmo.diplomaairline.model.dto.full.FullErrorDto;
import ru.itmo.diplomaairline.repository.ErrorRepository;
import ru.itmo.diplomaairline.service.data.ErrorService;

/**
 * реализация {@link ErrorService}
 */
@Service
public class ErrorServiceImpl implements ErrorService {

    @Autowired
    private ErrorRepository errorRepository;
    @Autowired
    private ErrorMapper errorMapper;

    @Override
    public void saveError(FullErrorDto fullErrorDto) {
        errorRepository.save(errorMapper.fullDtoToError(fullErrorDto));
    }
}
