package com.projects.employee.services;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.entities.Department;
import com.projects.employee.entities.Positions;
import com.projects.employee.requesties.PositionRequestData;
import com.projects.employee.responses.PositionResponseData;

import java.util.List;

public interface PositionService {
    PositionResponseData create(PositionRequestData positionDTO);

    List<PositionResponseData> listPositions();
    List<PositionResponseData> findPositionsByDepartment(Department department);
}
