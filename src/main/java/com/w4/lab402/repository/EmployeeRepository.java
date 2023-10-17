package com.w4.lab402.repository;

import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    public List<Employee> getAllEmployeesByStatus(EmployeeStatus status);
    public List<Employee> getAllEmployeesByDepartment(String department);
}
