package com.projects.employee.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.employee.entities.Employee;
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
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDTO {
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

    DepartmentDTO departmentDTO;
    @NotNull
    PositionDTO positionDTO;

    public static EmployeeDTO buildBy(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .fatherName(employee.getFatherName())
                .gender(employee.getGender())
                .birthDay(employee.getBirthDay())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .address(employee.getAddress())
                .role(employee.getRole())
                .departmentDTO(DepartmentDTO.buildBy(employee.getDepartment()))
                .positionDTO(PositionDTO.buildBy(employee.getPosition()))
                .build();
    }

    public static List<EmployeeDTO> buildBy(List<Employee> employees) {
        return employees.stream().map(EmployeeDTO::buildBy).collect(Collectors.toList());
    }


    public static Employee buildEmployee(EmployeeDTO employee) {
        return Employee.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .fatherName(employee.getFatherName())
                .gender(employee.getGender())
                .birthDay(employee.getBirthDay())
                .email(employee.getEmail())
                .salary(employee.getSalary())
                .address(employee.getAddress())
                .role(employee.getRole())
                .department(DepartmentDTO.buildDepartment(employee.getDepartmentDTO()))
                .position(PositionDTO.buildPosition(employee.getPositionDTO()))
                .build();
    }
}
