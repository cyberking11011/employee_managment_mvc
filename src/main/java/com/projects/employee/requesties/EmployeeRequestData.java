package com.projects.employee.requesties;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.enums.Gender;
import com.projects.employee.enums.Role;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequestData {
    @NotNull
    UUID id;
    @NotNull
    String name;
    @NotNull
    String surname;
    @NotNull
    String fatherName;
    @NotNull
    Gender gender;
    @Temporal(TemporalType.DATE)
    LocalDate birthDay;
    @NotNull
    @NotBlank
    @Email(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")
    String email;
    @NotNull
    @NotBlank
    Double salary;
    String address;
    @NotNull
    @NotBlank
    Role role;
    @NotNull
    DepartmentDTO departmentDTO;
    @NotNull
    PositionRequestData positionRequestData;


}
