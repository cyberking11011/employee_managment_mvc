package com.projects.employee.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ExceptionEmployee {
    USER_NOT_FOUND_BY_ID("User not found by id: ", 1),
    USER_NOT_FOUND_BY_ROLE("User not found by role: ", 2),
    INPUT_VALUE_FORMAT_NOT_CORRECT("User id must be in 'UUID' format",3)
    ;

    String message;
    int number;


}
