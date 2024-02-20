package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.RoleMapper;
import ru.itmo.diplomaairline.model.dto.full.FullRoleDto;
import ru.itmo.diplomaairline.model.entity.Role;
import ru.itmo.diplomaairline.repository.RoleRepository;
import ru.itmo.diplomaairline.service.data.RoleService;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.RoleService}
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public FullRoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Role.class, id));
        return roleMapper.roleToFullDto(role);
    }
}
