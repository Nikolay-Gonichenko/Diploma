package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.RouteMapper;
import ru.itmo.diplomaairline.model.dto.full.FullRouteDto;
import ru.itmo.diplomaairline.model.entity.Route;
import ru.itmo.diplomaairline.repository.RouteRepository;
import ru.itmo.diplomaairline.service.data.RouteService;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteMapper routeMapper;
    @Autowired
    private RouteRepository routeRepository;

    @Override
    public FullRouteDto getRouteById(Long id) {
        Route route = routeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Route.class, id));
        return routeMapper.routeToFullDto(route);
    }
}
