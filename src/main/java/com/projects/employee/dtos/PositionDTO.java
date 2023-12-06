package com.projects.employee.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.employee.entities.Department;
import com.projects.employee.entities.Positions;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PositionDTO{

    @NotNull
    UUID id;
    @NotNull
    @NotBlank
    String name;
    @NotNull
    Department department;

    public static PositionDTO buildBy(Positions position) {
        return PositionDTO.builder()
                .id(position.getId())
                .name(position.getName())
                .department(position.getDepartment())
                .build();
    }

    public static List<PositionDTO> buildBy(List<Positions> positions) {
        return positions.stream().map(PositionDTO::buildBy).collect(Collectors.toList());
    }

    public static Positions buildPosition(PositionDTO data) {
        return Positions.builder()
                .id(data.getId())
                .name(data.getName())
                .department(data.getDepartment())
                .build();
    }

    public static List<Positions> buildPositionList(List<PositionDTO> positionRequestDataList) {
        return positionRequestDataList.stream().map(PositionDTO::buildPosition).collect(Collectors.toList());
    }
}
