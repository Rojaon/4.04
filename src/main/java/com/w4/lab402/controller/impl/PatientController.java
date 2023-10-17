package com.w4.lab402.controller.impl;

import com.w4.lab402.controller.interfaces.IPatientController;
import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.model.Patient;
import com.w4.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable(name = "id") Integer id) {
        Optional<Patient> patientOptional = patientRepository.findById(id);
        if (patientOptional.isEmpty()) return null;
        return patientOptional.get();
    }
    @GetMapping("/patients/department/{department}")
    public List<Patient> findAllWhereDepartmentParams(@PathVariable(name = "department") String department) {
        List<Patient> patientList = patientRepository.findAllWhereDepartmentParams(department);
        if (patientList.isEmpty()) return null;
        return patientList;
    }
    @GetMapping("/patients/DateOfBirth")
    public List<Patient> findAllByDateOfBirthBetween(
            @RequestParam(defaultValue = "1931-11-10") String startDate,
            @RequestParam(defaultValue = "1999-02-15") String endDate) {
        List<Patient> patientList = patientRepository.findAllByDateOfBirthBetween(startDate,endDate);
        if (patientList.isEmpty()) return null;
        return patientList;
    }

    @GetMapping("/patients/statusOff")
    public List<Patient> findAllWhereStatusEqualsOFF(){
        return patientRepository.findAllWhereStatusEqualsOFF();
    }
}
