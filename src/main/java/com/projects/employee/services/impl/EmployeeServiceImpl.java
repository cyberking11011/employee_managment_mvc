package com.projects.employee.services.impl;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.dtos.EmployeeDTO;
import com.projects.employee.dtos.PositionDTO;
import com.projects.employee.entities.Employee;
import com.projects.employee.exceptions.ExceptionEmployee;
import com.projects.employee.exceptions.ServiceException;
import com.projects.employee.repositories.EmployeeRepository;
import com.projects.employee.services.EmployeeService;
import com.projects.employee.services.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;
    PositionService positionService;


    @Override
    public EmployeeDTO create(EmployeeDTO requestData) {
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
                .department(DepartmentDTO.buildDepartment(
                        positionService.selectDepartmentByPositionID(requestData.getPositionDTO().getId())))
                .position(PositionDTO.buildPosition(requestData.getPositionDTO()))
                .build();
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeDTO.buildBy(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> listEmployees() {

        return EmployeeDTO.buildBy(employeeRepository.findAll());
    }

    @Override
    public EmployeeDTO findById(UUID id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ServiceException(ExceptionEmployee.USER_NOT_FOUND_BY_ID));

        return EmployeeDTO.buildBy(employeeRepository.save(employee));
    }

    @Override
    public EmployeeDTO update(UUID id, EmployeeDTO employeeDTO) {
        EmployeeDTO employee = this.findById(id);

        employee.setId(id);
        employee.setName(employeeDTO.getName());
        employee.setSurname(employeeDTO.getSurname());
        employee.setFatherName(employeeDTO.getFatherName());
        employee.setGender(employeeDTO.getGender());
        employee.setBirthDay(employeeDTO.getBirthDay());
        employee.setEmail(employeeDTO.getEmail());
        employee.setSalary(employeeDTO.getSalary());
        employee.setRole(employeeDTO.getRole());
        employee.setAddress(employeeDTO.getAddress());
        employee.setDepartmentDTO(positionService.selectDepartmentByPositionID(employeeDTO.getPositionDTO().getId()));
        employee.setPositionDTO(employeeDTO.getPositionDTO());


        employeeRepository.save(EmployeeDTO.buildEmployee(employee));

        return employee;
    }

    @Override
    public void delete(UUID id) {
        employeeRepository.deleteById(id);
    }
}
