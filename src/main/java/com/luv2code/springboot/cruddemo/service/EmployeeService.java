package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {
    //get list of employees
    List<Employee> findAll();

    Employee findByID(String id);

    ResponseEntity<Employee> save(Employee employee);

    ResponseEntity<Void> deleteById(String id);
}
