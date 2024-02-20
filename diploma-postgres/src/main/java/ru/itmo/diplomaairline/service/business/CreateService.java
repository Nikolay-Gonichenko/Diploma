package ru.itmo.diplomaairline.service.business;

import ru.itmo.diplomaairline.model.dto.partial.ShortAccountDto;
import ru.itmo.diplomaairline.model.dto.partial.ShortEmployeeDto;
import ru.itmo.diplomaairline.model.dto.partial.ShortFlightDto;

/**
 * Сервис по созданию различных сущностей
 */
public interface CreateService {

    /**
     * Создание работника
     * @param employee дто работника
     * @return true если операция завершилась успешно
     */
    boolean createEmployee(ShortEmployeeDto employee);

    /**
     * Создание аккаунта
     * @param account дто аккаунта без id
     * @return иденфикатор аккаунта
     */
    Long createAccount(ShortAccountDto account);

    /**
     * Создание полёта
     * @param flight дто полёта с id параметров
     * @return идентификатор полёта
     */
    Long createFlight(ShortFlightDto flight);
}
