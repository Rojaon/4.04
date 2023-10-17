package com.w4.lab402.service.interfaces;

import com.w4.lab402.model.Patient;

import java.util.List;

public interface IPatientService {
    Patient getPatientById(Integer id);

    List<Patient> findAllWhereDepartmentParams(String department);

    List<Patient> findAllByDateOfBirthBetween(String startDate, String endDate);

    void updatePatient(Patient patient, Integer id);
}
