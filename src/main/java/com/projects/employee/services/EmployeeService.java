package com.projects.employee.services;

import com.projects.employee.requesties.EmployeeRequestData;
import com.projects.employee.responses.EmployeeResponseData;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseData create(EmployeeRequestData employee);
    List<EmployeeResponseData> listEmployees();

}
