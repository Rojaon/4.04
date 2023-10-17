package com.w4.lab402.repository;

import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy = e.employeeId WHERE e.department = ?1 ")
    List<Patient> findAllWhereDepartmentParams(String department);
    @Query("SELECT p FROM Patient p JOIN Employee e ON p.admittedBy = e.employeeId WHERE e.status = OFF ")
    List<Patient> findAllWhereStatusEqualsOFF();
    List<Patient> findAllByDateOfBirthBetween(String startDate, String endDate);
}
