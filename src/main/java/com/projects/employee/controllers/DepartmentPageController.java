package com.projects.employee.controllers.webmvc;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.services.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentPageController {
    DepartmentService departmentService;
    static String DEPARTMENTS = "departments";
    static String REDIRECT_TO_DEPARTMENTS = "redirect:/departments";

    @GetMapping
    public String listDepartments(Model model) {
        model.addAttribute("departments", departmentService.listDepartments());
        model.addAttribute("departmentDTO", new DepartmentDTO());
        return DEPARTMENTS;
    }


    @PostMapping("/create")
    public String create(DepartmentDTO departmentDTO) {
        System.out.println(departmentDTO.toString());
        departmentService.create(departmentDTO);
        return REDIRECT_TO_DEPARTMENTS;
    }
}
