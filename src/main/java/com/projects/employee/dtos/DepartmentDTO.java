package com.projects.employee.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.employee.entities.Department;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDTO {
    @NotNull
    UUID id;
    @NotNull
    @NotBlank
    String name;

    public static DepartmentDTO buildBy(Department department) {
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .build();
    }

    public static List<DepartmentDTO> buildBy(List<Department> departments) {
        return departments.stream().map(DepartmentDTO::buildBy).collect(Collectors.toList());
    }

    public static Department buildDepartment(DepartmentDTO departmentDTO) {
        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .build();

    }

    public static List<Department> buildDepartmentList(List<DepartmentDTO> departmentDTOList) {
        return departmentDTOList.stream().map(DepartmentDTO::buildDepartment).collect(Collectors.toList());
    }
}
