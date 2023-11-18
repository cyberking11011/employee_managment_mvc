package com.projects.employee.entities;

import com.projects.employee.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.UUID;

@MappedSuperclass
@SuperBuilder(toBuilder = true)
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BaseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(name = "father",nullable = false)
    private String fatherName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "birth")
    private LocalDate birthDay;
    @Column(nullable = false)
    private String email;


}
