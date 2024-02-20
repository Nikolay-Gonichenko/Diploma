package ru.itmo.diplomaairline.exception.base;

import ru.itmo.diplomaairline.exception.ExceptionType;

/**
 * Базовое исключение, от которого наследуются все остальные
 */
public abstract class BaseException extends RuntimeException {
    private final ExceptionType type;

    public BaseException(ExceptionType type) {
        this.type = type;
    }

    public ExceptionType getType() {
        return type;
    }

    public abstract String getDescription();
}
