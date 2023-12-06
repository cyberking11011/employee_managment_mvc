package com.projects.employee.controllers;

import com.projects.employee.dtos.EmployeeDTO;
import com.projects.employee.enums.Gender;
import com.projects.employee.enums.Role;
import com.projects.employee.services.DepartmentService;
import com.projects.employee.services.EmployeeService;
import com.projects.employee.services.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeePageController {
    EmployeeService employeeService;
    PositionService positionService;
    DepartmentService departmentService;

    public String EMPLOYEES_TABLE = "employees-table";
    public String EMPLOYEE = "employee";
    public String REDIRECT_TO_EMPLOYEES = "redirect:/employees";
    public String UPDATE_EMPLOYEE = "update-employee";

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.listEmployees());
        model.addAttribute("employeeCount", employeeService.listEmployees().size());
        return EMPLOYEES_TABLE;
    }

    @GetMapping("/create")
    public String autoFill(Model model) {
        Map<String, Object> map = listModels();
        EmployeeDTO employeeDTO = new EmployeeDTO();
        map.put("employeeDTO", employeeDTO);

        model.addAllAttributes(map);

        return EMPLOYEE;
    }


    @PostMapping(value = "/create")
    public String create(EmployeeDTO EmployeeDTO) {
        employeeService.create(EmployeeDTO);
        return REDIRECT_TO_EMPLOYEES;
    }

    @GetMapping(path = "/update-employee/{id}")
    public String update(Model model, @PathVariable("id") UUID id) {
        Map<String, Object> modelMap = listModels();
        EmployeeDTO employeeDTO = employeeService.findById(id);
        modelMap.put("employeeDTO", employeeDTO);
        model.addAllAttributes(modelMap);

        return UPDATE_EMPLOYEE;
    }

    @PostMapping(value = "/update-employee/{id}")
    public String updateEmployee(@PathVariable("id") UUID id, EmployeeDTO employee) {

        employeeService.update(id, employee);
        return REDIRECT_TO_EMPLOYEES;
    }

    @GetMapping(path = "/delete-employee/{id}")
    public String delete(@PathVariable("id") UUID id) {
        employeeService.delete(id);

        return REDIRECT_TO_EMPLOYEES;
    }

    private Map<String, Object> listModels() {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("departments", departmentService.listDepartments());
        modelMap.put("positions", positionService.listPositions());
        modelMap.put("genders", Gender.values());
        modelMap.put("roles", Role.values());
        modelMap.put("employees", employeeService.listEmployees());
        return modelMap;
    }
}
