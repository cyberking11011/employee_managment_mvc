package com.projects.employee.exceptions;

import com.projects.employee.responses.ErrorResponseData;
import com.projects.employee.responses.ResponseData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ResponseData<ErrorResponseData>> handleError(ServiceException exception) {
        return ResponseEntity.ok
                (ResponseData.buildBy(ErrorResponseData.buildBy(exception.getNumber(), exception.getMessage())));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseData<ErrorResponseData>> handleError() {
        return ResponseEntity.ok
                (ResponseData.buildBy(ErrorResponseData.buildBy(
                        3,
                        ExceptionEmployee.INPUT_VALUE_FORMAT_NOT_CORRECT.getMessage())));
    }

//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ResponseData<ErrorResponseData>> handleError(MethodArgumentNotValidException e) {
//        return ResponseEntity.ok
//                (ResponseData.buildBy(ErrorResponseData.buildBy(e.getErrorCount(),e.getBody().getDetail())));
//    }
}
