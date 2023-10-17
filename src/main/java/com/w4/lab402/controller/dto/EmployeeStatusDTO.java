package com.w4.lab402.controller.dto;

import com.w4.lab402.model.EmployeeStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


public class EmployeeStatusDTO {

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    public EmployeeStatus getStatus() {
        return status;
    }
}
