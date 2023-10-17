package com.w4.lab402.controller.interfaces;

import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.model.Patient;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IPatientController {
    public List<Patient> getAllPatients();
    public Patient getPatientById(Integer id);
    public List<Patient> findAllWhereDepartmentParams(String department);
    List<Patient> findAllWhereStatusEqualsOFF();
    List<Patient> findAllByDateOfBirthBetween(String startDate, String endDate);
    public void savePatients(Patient patient);
    public void updatePatient(Patient patient, Integer id);
}
