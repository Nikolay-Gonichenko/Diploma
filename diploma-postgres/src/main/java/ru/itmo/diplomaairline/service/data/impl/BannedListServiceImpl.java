package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.mapper.BannedListMapper;
import ru.itmo.diplomaairline.model.dto.full.FullBannedListDto;
import ru.itmo.diplomaairline.repository.BannedListRepository;
import ru.itmo.diplomaairline.service.data.BannedListService;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.BannedListService}
 */
@Service
public class BannedListServiceImpl implements BannedListService {

    @Autowired
    private BannedListRepository bannedListRepository;
    @Autowired
    private BannedListMapper bannedListMapper;

    @Override
    public Boolean saveBannedList(FullBannedListDto bannedListDto) {
        bannedListRepository.save(bannedListMapper.fullDtoToBannedList(bannedListDto));
        return true;
    }
}
