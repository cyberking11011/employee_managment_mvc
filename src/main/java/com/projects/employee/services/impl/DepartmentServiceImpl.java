package com.projects.employee.services.impl;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.entities.Department;
import com.projects.employee.repositories.DepartmentRepository;
import com.projects.employee.services.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO create(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .name(departmentDTO.getName())
                .build();
        return DepartmentDTO.buildBy(departmentRepository.save(department));
    }

    @Override
    public List<DepartmentDTO> listDepartments() {
        return DepartmentDTO.buildBy(departmentRepository.findAll());
    }
}
