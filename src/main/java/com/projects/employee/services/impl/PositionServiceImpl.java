package com.projects.employee.services.impl;

import com.projects.employee.entities.Department;
import com.projects.employee.entities.Positions;
import com.projects.employee.repositories.PositionRepository;
import com.projects.employee.requesties.PositionRequestData;
import com.projects.employee.responses.PositionResponseData;
import com.projects.employee.services.PositionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PositionServiceImpl implements PositionService {
    PositionRepository positionRepository;

    @Override
    public PositionResponseData create(PositionRequestData positionDTO) {
        Positions position = Positions.builder()
                .name(positionDTO.getName())
                .department(positionDTO.getDepartment())
                .build();
        Positions savedPosition = positionRepository.save(position);
        return PositionResponseData.buildBy(savedPosition);
    }

    @Override
    public List<PositionResponseData> listPositions() {
        return PositionResponseData.buildBy(positionRepository.findAll());
    }

    @Override
    public List<PositionResponseData> findPositionsByDepartment(Department department) {
        return positionRepository.findPositionsByDepartment(department);
    }
}
