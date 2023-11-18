package com.projects.employee.repositories;

import com.projects.employee.dtos.DepartmentDTO;
import com.projects.employee.entities.Department;
import com.projects.employee.entities.Positions;
import com.projects.employee.responses.PositionResponseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PositionRepository extends JpaRepository<Positions, UUID> {
    @Query("SELECT p FROM Positions p WHERE p.department= :department")
    List<PositionResponseData> findPositionsByDepartment(Department department);
}
