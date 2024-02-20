package ru.itmo.diplomaairline.exception.data;

import lombok.Getter;
import ru.itmo.diplomaairline.exception.ExceptionType;
import ru.itmo.diplomaairline.exception.base.BaseException;

/**
 * Исключение выбрасывается когда не найдена сущность по id
 */
@Getter
public class NotFoundEntityByIdException extends BaseException {

    private final Class<?> clazz;
    private final Long id;

    public NotFoundEntityByIdException(Class<?> clazz, Long id) {
        super(ExceptionType.DATA);
        this.clazz = clazz;
        this.id = id;
    }

    @Override
    public String getDescription() {
        return "Не найден объект класса " + clazz.getSimpleName() + " с id=" + id;
    }
}
