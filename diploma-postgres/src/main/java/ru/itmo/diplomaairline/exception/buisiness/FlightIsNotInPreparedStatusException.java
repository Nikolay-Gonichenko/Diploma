package ru.itmo.diplomaairline.exception.buisiness;

import ru.itmo.diplomaairline.exception.ExceptionType;
import ru.itmo.diplomaairline.exception.base.BaseException;

/**
 * Исключение выбрасывается при попытке добавить работника к полёту,
 * который уже подготовлен
 */
public class FlightIsNotInPreparedStatusException extends BaseException {

    public FlightIsNotInPreparedStatusException() {
        super(ExceptionType.BUSINESS_MANAGER);
    }


    @Override
    public String getDescription() {
        return "Самолёт уже подготовлен. Добавление новых работников недоступно";
    }
}
