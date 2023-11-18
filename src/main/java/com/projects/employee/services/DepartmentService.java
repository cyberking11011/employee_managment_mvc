package com.projects.employee.services;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.entities.Department;

import java.util.List;

public interface DepartmentService {
    DepartmentDTO create(DepartmentDTO departmentDTO);
    List<DepartmentDTO> listDepartments();
}
