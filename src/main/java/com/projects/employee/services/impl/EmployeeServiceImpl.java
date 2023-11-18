package com.projects.employee.services.impl;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.entities.Employee;
import com.projects.employee.repositories.EmployeeRepository;
import com.projects.employee.requesties.EmployeeRequestData;
import com.projects.employee.responses.EmployeeResponseData;
import com.projects.employee.responses.PositionResponseData;
import com.projects.employee.services.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponseData create(EmployeeRequestData requestData) {
        Employee employee = Employee.builder()
                .name(requestData.getName())
                .surname(requestData.getSurname())
                .fatherName(requestData.getFatherName())
                .gender(requestData.getGender())
                .birthDay(requestData.getBirthDay())
                .email(requestData.getEmail())
                .salary(requestData.getSalary())
                .role(requestData.getRole())
                .address(requestData.getAddress())
                .department(DepartmentDTO.buildDepartment(requestData.getDepartmentDTO()))
                .position(PositionResponseData.buildPosition(requestData.getPositionRequestData()))
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeResponseData.buildBy(savedEmployee);
    }

    @Override
    public List<EmployeeResponseData> listEmployees() {
        return EmployeeResponseData.buildBy(employeeRepository.findAll());
    }
}
