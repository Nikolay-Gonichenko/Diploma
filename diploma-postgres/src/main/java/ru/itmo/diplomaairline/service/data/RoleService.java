package ru.itmo.diplomaairline.service.data;

import ru.itmo.diplomaairline.model.dto.full.FullRoleDto;

/**
 * Сервис для работы с сущностью Роли
 */
public interface RoleService {
    /**
     * Возвращает роль по id
     * @param id идентификатор роли
     * @return полное дто роли
     */
    FullRoleDto getRoleById(Long id);
}
