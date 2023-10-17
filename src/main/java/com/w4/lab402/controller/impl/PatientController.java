package com.w4.lab402.controller.impl;

import com.w4.lab402.controller.interfaces.IPatientController;
import com.w4.lab402.model.Patient;
import com.w4.lab402.repository.PatientRepository;
import com.w4.lab402.service.interfaces.IPatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientController implements IPatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    IPatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable(name = "id") Integer id) {
        return patientService.getPatientById(id);
    }
    @GetMapping("/patients/department/{department}")
    public List<Patient> findAllWhereDepartmentParams(@PathVariable(name = "department") String department) {
        return patientService.findAllWhereDepartmentParams(department);
    }
    @GetMapping("/patients/DateOfBirth")
    public List<Patient> findAllByDateOfBirthBetween(
            @RequestParam(defaultValue = "1931-11-10") String startDate,
            @RequestParam(defaultValue = "1999-02-15") String endDate) {
        return patientService.findAllByDateOfBirthBetween(startDate,endDate);
    }
    @GetMapping("/patients/statusOff")
    public List<Patient> findAllWhereStatusEqualsOFF(){
        return patientRepository.findAllWhereStatusEqualsOFF();
    }

    @PostMapping("/patients")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePatients(@RequestBody @Valid Patient patient) {
        patientRepository.save(patient);
    }

    @PutMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatient(@RequestBody @Valid Patient patient, @PathVariable Integer id) {
        patientService.updatePatient(patient, id);
    }
}
