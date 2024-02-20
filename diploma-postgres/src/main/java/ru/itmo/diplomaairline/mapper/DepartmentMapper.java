package ru.itmo.diplomaairline.mapper;


import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullDepartmentDto;
import ru.itmo.diplomaairline.model.entity.Department;

/**
 * Мапер департамента
 */
@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    FullDepartmentDto departmentToFullDto(Department department);
}
