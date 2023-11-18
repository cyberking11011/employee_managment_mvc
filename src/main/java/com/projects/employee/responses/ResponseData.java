package com.projects.employee.responses;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseData<T> {
    T result;
    ErrorResponseData error;

    public static <T> ResponseData<T> buildBy(T result) {
        return ResponseData.<T>builder()
                .result(result)
                .error(null)
                .build();
    }

    public static <T> ResponseData<T> buildBy(ErrorResponseData error) {
        return ResponseData.<T>builder()
                .result(null)
                .error(error)
                .build();
    }
}
