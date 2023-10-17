package com.w4.lab402.controller.interfaces;

import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.model.Patient;

import java.util.List;

public interface IPatientController {
    public List<Patient> getAllPatients();
    public Patient getPatientById(Integer id);
    public List<Patient> findAllWhereDepartmentParams(String department);
    List<Patient> findAllWhereStatusEqualsOFF();
    List<Patient> findAllByDateOfBirthBetween(String startDate, String endDate);
}
