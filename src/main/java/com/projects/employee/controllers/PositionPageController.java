package com.projects.employee.controllers;

import com.projects.employee.dtos.PositionDTO;
import com.projects.employee.services.DepartmentService;
import com.projects.employee.services.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/positions")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PositionPageController {
    PositionService positionService;
    DepartmentService departmentService;

    public String POSITIONS = "positions";
    public String REDIRECT_TO_POSITIONS = "redirect:/positions";

    @GetMapping
    public String listPositions(Model model) {
        model.addAttribute("positions", positionService.listPositions());
        model.addAttribute("positionRequestData", new PositionDTO());
        model.addAttribute("departments", departmentService.listDepartments());
        return POSITIONS;
    }

    @PostMapping("/create")
    public String create(PositionDTO positionRequestData) {
        System.out.println(positionRequestData.toString());
        positionService.create(positionRequestData);
        return REDIRECT_TO_POSITIONS;
    }
}
