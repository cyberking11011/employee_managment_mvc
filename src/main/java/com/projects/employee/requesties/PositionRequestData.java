package com.projects.employee.requesties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.employee.entities.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PositionRequestData {
    @NotNull
    UUID id;
    @NotNull
    @NotBlank
    String name;
    @NotNull
    Department department;


}
