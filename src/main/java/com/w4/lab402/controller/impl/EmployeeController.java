package com.w4.lab402.controller.impl;

import com.w4.lab402.controller.dto.EmployeeDepartmentDTO;
import com.w4.lab402.controller.dto.EmployeeStatusDTO;
import com.w4.lab402.controller.interfaces.IEmployeeController;
import com.w4.lab402.model.Employee;
import com.w4.lab402.model.EmployeeStatus;
import com.w4.lab402.repository.EmployeeRepository;
import com.w4.lab402.service.interfaces.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController implements IEmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/employees/status/{status}")
    public List<Employee> getAllEmployeesByStatus(@PathVariable(name = "status") EmployeeStatus status) {
        return employeeService.getAllEmployeesByStatus(status);
    }
    @GetMapping("/employees/department/{department}")
    public List<Employee> getAllEmployeesByDepartment(@PathVariable(name = "department") String department) {
        return employeeService.getAllEmployeesByDepartment(department);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmployee(@RequestBody @Valid Employee employee) {
        employeeRepository.save(employee);
    }

    @PatchMapping("/employees/department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeDepartment(@RequestBody @Valid EmployeeDepartmentDTO employeeDepartmentDTO, @PathVariable Integer id) {
        employeeService.updateEmployeeDepartment(employeeDepartmentDTO.getDepartment(), id);
    }

    @PatchMapping("/employees/status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployeeStatus(@RequestBody EmployeeStatusDTO employeeStatusDTO, @PathVariable Integer id) {
        employeeService.updateEmployeeStatus(employeeStatusDTO.getStatus(), id);
    }

}
