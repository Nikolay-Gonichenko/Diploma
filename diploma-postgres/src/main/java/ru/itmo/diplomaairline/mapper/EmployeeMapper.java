package ru.itmo.diplomaairline.mapper;

import org.mapstruct.Mapper;
import ru.itmo.diplomaairline.model.dto.full.FullEmployeeDto;
import ru.itmo.diplomaairline.model.entity.Employee;

/**
 * Мапер сущности Работник
 */
@Mapper(componentModel = "spring", uses = {AccountMapper.class, PositionMapper.class})
public interface EmployeeMapper {

    Employee fullDtoToEmployee(FullEmployeeDto employee);

    FullEmployeeDto employeeToFullDto(Employee employee);
}
