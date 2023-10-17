package com.w4.lab402.controller.interfaces;

import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IEmployeeController {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Integer id);
    public List<Employee> getAllEmployeesByStatus(EmployeeStatus status);
    public List<Employee> getAllEmployeesByDepartment(String department);
}
