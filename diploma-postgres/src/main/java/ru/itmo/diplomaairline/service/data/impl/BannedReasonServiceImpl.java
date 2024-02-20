package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.BannedReasonMapper;
import ru.itmo.diplomaairline.model.dto.full.FullBannedReasonDto;
import ru.itmo.diplomaairline.model.entity.BannedReason;
import ru.itmo.diplomaairline.repository.BannedReasonRepository;
import ru.itmo.diplomaairline.service.data.BannedReasonService;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.BannedReasonService}
 */
@Service
public class BannedReasonServiceImpl implements BannedReasonService {
    @Autowired
    private BannedReasonRepository bannedReasonRepository;
    @Autowired
    private BannedReasonMapper bannedReasonMapper;

    @Override
    public FullBannedReasonDto getBannedReasonById(Long id) {
        BannedReason bannedReason = bannedReasonRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(BannedReason.class, id));
        return bannedReasonMapper.bannedReasonToFullDto(bannedReason);
    }
}
