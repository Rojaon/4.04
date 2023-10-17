package com.w4.lab402.service.impl;

import com.w4.lab402.model.Patient;
import com.w4.lab402.repository.PatientRepository;
import com.w4.lab402.service.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient getPatientById(Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }
    @Override
    public List<Patient> findAllWhereDepartmentParams(String department) {
        List<Patient> patientList = patientRepository.findAllWhereDepartmentParams(department);
        if (patientList.isEmpty()) return null;
        return patientList;
    }
    @Override
    public List<Patient> findAllByDateOfBirthBetween(String startDate, String endDate) {
        List<Patient> patientList = patientRepository.findAllByDateOfBirthBetween(startDate,endDate);
        if (patientList.isEmpty()) return null;
        return patientList;
    }

    @Override
    public void updatePatient(Patient patient, Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return;
        patient.setPatientId(id);
        patientRepository.save(patient);
    }
}
