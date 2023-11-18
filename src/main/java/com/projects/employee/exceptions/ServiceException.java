package com.projects.employee.exceptions;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class ServiceException extends RuntimeException {
    int number;

    public ServiceException(int number, String message) {
        super(message);
        this.number = number;
    }

    public ServiceException(ExceptionEmployee exceptionEmployee) {
        super(exceptionEmployee.message);
        this.number = exceptionEmployee.number;
    }
}
