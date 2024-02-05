package com.luv2code.springboot.thymeleaf.dao;

import com.luv2code.springboot.thymeleaf.model.Employee;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeDAO {
    //get list of employees
    List<Employee> findAll();
    Employee findByID(int id);
    ResponseEntity<Employee> save (Employee employee);
    void   deleteById(int id);
    List<Employee> sortByName();
}
