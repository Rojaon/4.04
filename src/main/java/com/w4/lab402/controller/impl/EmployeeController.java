package com.w4.lab402.controller.impl;

import com.w4.lab402.controller.interfaces.IEmployeeController;
import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.model.Patient;
import com.w4.lab402.repository.EmployeeRepository;
import com.w4.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController implements IEmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        if (employeeList.isEmpty()) return null;
        return employeeList;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }
    @GetMapping("/employees/status/{status}")
    public List<Employee> getAllEmployeesByStatus(@PathVariable(name = "status") EmployeeStatus status) {
        List<Employee> employeeList = employeeRepository.getAllEmployeesByStatus(status);
        if (employeeList.isEmpty()) return null;
        return employeeList;
    }
    @GetMapping("/employees/department/{department}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable(name = "department") String department) {
        List<Employee> employeeList = employeeRepository.getAllEmployeesByDepartment(department);
        if (employeeList.isEmpty()) return null;
        return employeeList;
    }

}
