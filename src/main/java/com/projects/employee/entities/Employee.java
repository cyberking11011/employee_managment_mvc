package com.projects.employee.entities;

import com.projects.employee.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employee extends BaseUser {
    @Column(name = "salary", nullable = false)
    Double salary;

    String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    Role role;

    @ManyToOne
    @JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "fk_department_id"))
    Department department;

    @ManyToOne
    @JoinColumn(name = "position_id", foreignKey = @ForeignKey(name = "fk_position_id"))
    Positions position;


}
