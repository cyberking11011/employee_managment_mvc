package com.projects.employee.services;


import com.projects.employee.dtos.EmployeeDTO;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeDTO create(EmployeeDTO employee);

    List<EmployeeDTO> listEmployees();

    EmployeeDTO findById(UUID id);

    EmployeeDTO update(UUID id, EmployeeDTO employee);

    void delete(UUID id);

}
