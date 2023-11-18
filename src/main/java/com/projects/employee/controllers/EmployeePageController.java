package com.projects.employee.controllers.webmvc;

import com.projects.employee.enums.Gender;
import com.projects.employee.enums.Role;
import com.projects.employee.requesties.EmployeeRequestData;
import com.projects.employee.services.DepartmentService;
import com.projects.employee.services.EmployeeService;
import com.projects.employee.services.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeePageController {
    EmployeeService employeeService;
    PositionService positionService;
    DepartmentService departmentService;

    static String EMPLOYEES_TABLE = "employees-table";
    static String EMPLOYEES = "employee";
    static String REDIRECT_TO_EMPLOYEES = "redirect:/employees";

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.listEmployees());
        model.addAttribute("employeeCount", (long) employeeService.listEmployees().size());
        return EMPLOYEES_TABLE;
    }

    @GetMapping("/create")
    public String autoFill(Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("departments", departmentService.listDepartments());
        map.put("positions", positionService.listPositions());
        map.put("genders", Gender.values());
        map.put("roles", Role.values());
        map.put("employees", employeeService.listEmployees());

        map.put("employeeRequestData", new EmployeeRequestData());

        model.addAllAttributes(map);

        return EMPLOYEES;
    }


    @PostMapping(value = "/create")
    public String create(EmployeeRequestData employeeRequestData) {
        System.out.println(employeeRequestData.toString());
        employeeService.create(employeeRequestData);
        return REDIRECT_TO_EMPLOYEES;
    }
}
