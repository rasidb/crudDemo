package com.luv2code.springboot.cruddemo.service.impl;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.rest.exception.EmployeeBadRequestException;
import com.luv2code.springboot.cruddemo.rest.exception.EmployeeNotFoundException;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findByID(String id) {
        int theId;
        try {
            theId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new EmployeeBadRequestException("Bad Request: " + id);
        }
        return employeeDAO.findByID(theId);
    }

    @Override
    @Transactional
    public ResponseEntity<Employee> save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public ResponseEntity<Void> deleteById(String id) {
        int theID;
        try {
            theID = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new EmployeeBadRequestException("bad request: " + id);
        }

        Employee employee = employeeDAO.findByID(theID);
        if (employee == null)
            throw new EmployeeNotFoundException("employee not found");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
