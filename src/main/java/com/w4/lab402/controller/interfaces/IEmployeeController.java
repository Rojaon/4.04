package com.w4.lab402.controller.interfaces;

import com.w4.lab402.controller.dto.EmployeeDepartmentDTO;
import com.w4.lab402.controller.dto.EmployeeStatusDTO;
import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.model.Patient;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IEmployeeController {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(Integer id);
    public List<Employee> getAllEmployeesByStatus(EmployeeStatus status);
    public List<Employee> getAllEmployeesByDepartment(String department);
    public void saveEmployee(Employee employee);
    public void updateEmployeeDepartment(EmployeeDepartmentDTO employeeDepartmentDTO, Integer id);
    public void updateEmployeeStatus(EmployeeStatusDTO employeeStatusDTO, Integer id);
}
