package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeDAO {
    //get list of employees
    List<Employee> findAll();
    Employee findByID(int id);
    ResponseEntity<Employee> save (Employee employee);
    void   deleteById(int id);
}
