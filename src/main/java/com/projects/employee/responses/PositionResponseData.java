package com.projects.employee.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.employee.entities.Department;
import com.projects.employee.entities.Positions;
import com.projects.employee.requesties.PositionRequestData;
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
public class PositionResponseData {

    @NotNull
    UUID id;
    @NotNull
    @NotBlank
    String name;
    @NotNull
    Department department;

    public static PositionResponseData buildBy(Positions position) {
        return PositionResponseData.builder()
                .id(position.getId())
                .name(position.getName())
                .department(position.getDepartment())
                .build();
    }

    public static List<PositionResponseData> buildBy(List<Positions> positions) {
        return positions.stream().map(PositionResponseData::buildBy).collect(Collectors.toList());
    }

    public static Positions buildPosition(PositionRequestData data) {
        return Positions.builder()
                .id(data.getId())
                .name(data.getName())
                .department(data.getDepartment())
                .build();
    }

    public static List<Positions> buildPositionList(List<PositionRequestData> positionRequestDataList) {
        return positionRequestDataList.stream().map(PositionResponseData::buildPosition).collect(Collectors.toList());
    }
}
