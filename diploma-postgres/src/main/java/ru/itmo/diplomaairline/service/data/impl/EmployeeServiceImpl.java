package ru.itmo.diplomaairline.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.diplomaairline.exception.data.NotFoundEntityByIdException;
import ru.itmo.diplomaairline.mapper.EmployeeMapper;
import ru.itmo.diplomaairline.model.dto.full.FullEmployeeDto;
import ru.itmo.diplomaairline.model.entity.Employee;
import ru.itmo.diplomaairline.repository.EmployeeRepository;
import ru.itmo.diplomaairline.service.data.EmployeeService;

/**
 * Реализация {@link ru.itmo.diplomaairline.service.data.EmployeeService}
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public boolean saveEmployee(FullEmployeeDto employeeDto) {
        employeeRepository.save(employeeMapper.fullDtoToEmployee(employeeDto));
        return true;
    }

    @Override
    public FullEmployeeDto getById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Employee.class, id));
        return employeeMapper.employeeToFullDto(employee);
    }
}
