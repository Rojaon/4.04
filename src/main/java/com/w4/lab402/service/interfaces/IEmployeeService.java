package com.w4.lab402.service.interfaces;

import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployeesByStatus(EmployeeStatus status);

    List<Employee> getAllEmployeesByDepartment(String department);

    void updateEmployeeDepartment(String department, Integer id);

    void updateEmployeeStatus(EmployeeStatus status, Integer id);
}
