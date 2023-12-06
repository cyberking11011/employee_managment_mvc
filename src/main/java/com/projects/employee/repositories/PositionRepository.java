package com.projects.employee.repositories;

import com.projects.employee.entities.Department;
import com.projects.employee.entities.Positions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PositionRepository extends JpaRepository<Positions, UUID> {

    @Query(value = "SELECT p FROM Positions p WHERE p.department.id  = :#{#departmentID}")
    List<Positions> selectPositionsByDepartment(@Param("departmentID") UUID departmentID);

    @Query("SELECT d FROM Positions p LEFT JOIN Department d ON p.department.id=d.id WHERE p.id=:#{#positionId}")
    Optional<Department> selectDepartmentByPositionID(@Param("positionId") UUID positionId);
}
