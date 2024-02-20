package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullRoleDto;
import ru.itmo.diplomaairline.model.entity.Role;

/**
 * Мапер роли
 */
@Mapper(componentModel = "spring")
public interface RoleMapper {

    FullRoleDto roleToFullDto(Role role);

    Role fullDtoToRole(FullRoleDto role);
}
