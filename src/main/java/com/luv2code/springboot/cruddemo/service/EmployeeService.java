package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    //get list of employees
    List<Employee> findAll();
    Employee findByID(int id);
    Employee save (Employee employee);
    void  deleteById(int id);
}
