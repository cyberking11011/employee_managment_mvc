package com.projects.employee.responses;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.entities.Employee;
import com.projects.employee.enums.Gender;
import com.projects.employee.enums.Role;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeResponseData {
    UUID id;
    String name;
    String surname;
    String fatherName;
    Gender gender;
    LocalDate birthDay;
    String email;
    Double salary;
    String address;
    Role role;
    PositionResponseData positionResponseData;
    DepartmentDTO departmentDTO;

    public static EmployeeResponseData buildBy(Employee employee) {
        return EmployeeResponseData.builder()
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
                .positionResponseData(PositionResponseData.buildBy(employee.getPosition()))
                .build();
    }

    public static List<EmployeeResponseData> buildBy(List<Employee> employees) {
        return employees.stream().map(EmployeeResponseData::buildBy).collect(Collectors.toList());
    }

}
