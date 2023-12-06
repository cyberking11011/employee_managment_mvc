package com.projects.employee.services.impl;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.dtos.PositionDTO;
import com.projects.employee.entities.Positions;
import com.projects.employee.exceptions.ExceptionEmployee;
import com.projects.employee.exceptions.ServiceException;
import com.projects.employee.repositories.PositionRepository;
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
public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository;

    @Override
    public PositionDTO create(PositionDTO positionDTO) {
        Positions position = Positions.builder()
                .name(positionDTO.getName())
                .department(positionDTO.getDepartment())
                .build();
        Positions savedPosition = positionRepository.save(position);
        return PositionDTO.buildBy(savedPosition);
    }

    @Override
    public List<PositionDTO> listPositions() {
        return PositionDTO.buildBy(positionRepository.findAll());
    }


    @Override
    public DepartmentDTO selectDepartmentByPositionID(UUID positionID) {
        return DepartmentDTO.buildBy(positionRepository.selectDepartmentByPositionID(positionID)
                .orElseThrow(() -> new ServiceException(ExceptionEmployee.DEPARTMENT_NOT_FOUND_FOR_POSITION_ID)));
    }
}
