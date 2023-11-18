package com.projects.employee.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponseData {
    int number;
    String message;
    public static ErrorResponseData buildBy(int number,String message){
        return ErrorResponseData.builder()
                .number(number)
                .message(message)
                .build();
    }
}
