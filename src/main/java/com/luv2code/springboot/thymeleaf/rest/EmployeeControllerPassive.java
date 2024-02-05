package com.luv2code.springboot.thymeleaf.rest;

import com.luv2code.springboot.thymeleaf.entity.Employee;
import com.luv2code.springboot.thymeleaf.rest.exception.EmployeeNotFoundException;
import com.luv2code.springboot.thymeleaf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeControllerPassive {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeControllerPassive(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable String id) {

        Employee employee = employeeService.findByID(id);
        if (employee == null)
            throw new EmployeeNotFoundException("employee not found");
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> remove(@PathVariable String id) {
        return employeeService.deleteById(id);
    }

}
