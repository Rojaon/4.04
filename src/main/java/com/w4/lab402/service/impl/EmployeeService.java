package com.w4.lab402.service.impl;

import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.repository.EmployeeRepository;
import com.w4.lab402.service.interfaces.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        if (employeeList.isEmpty()) return null;
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return null;
        return employeeOptional.get();
    }

    @Override
    public List<Employee> getAllEmployeesByStatus(EmployeeStatus status) {
        List<Employee> employeeList = employeeRepository.getAllEmployeesByStatus(status);
        if (employeeList.isEmpty()) return null;
        return employeeList;
    }

    @Override
    public List<Employee> getAllEmployeesByDepartment(String department) {
        List<Employee> employeeList = employeeRepository.getAllEmployeesByDepartment(department);
        if (employeeList.isEmpty()) return null;
        return employeeList;
    }

    @Override
    public void updateEmployeeDepartment(String department, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setDepartment(department);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployeeStatus(EmployeeStatus status, Integer id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isEmpty()) return;
        Employee employee = employeeOptional.get();
        employee.setStatus(status);
        employeeRepository.save(employee);
    }
}
