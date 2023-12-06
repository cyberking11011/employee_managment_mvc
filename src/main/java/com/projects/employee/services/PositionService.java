package com.projects.employee.services;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.dtos.PositionDTO;

import java.util.List;
import java.util.UUID;

public interface PositionService {
    PositionDTO create(PositionDTO positionDTO);

    List<PositionDTO> listPositions();
    DepartmentDTO selectDepartmentByPositionID(UUID positionID);
}
