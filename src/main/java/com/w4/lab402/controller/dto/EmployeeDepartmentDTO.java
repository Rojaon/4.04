package com.w4.lab402.controller.dto;

import jakarta.validation.constraints.NotEmpty;

public class EmployeeDepartmentDTO {
    @NotEmpty(message = "Department cannot be empty")
    private String department;

    public String getDepartment() {
        return department;
    }
}
