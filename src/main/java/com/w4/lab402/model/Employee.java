package com.w4.lab402.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    private Integer employeeId;
    @NotEmpty(message = "Department cannot be empty")
    private String department;
    private String name;
    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

}
