package com.luv2code.springboot.thymeleaf.dao.impl;

import com.luv2code.springboot.thymeleaf.dao.EmployeeDAO;
import com.luv2code.springboot.thymeleaf.model.Employee;
import com.luv2code.springboot.thymeleaf.rest.exception.EmployeeBadRequestException;
import com.luv2code.springboot.thymeleaf.rest.exception.EmployeeNotFoundException;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    //Create an EntityManager object
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findByID(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null)
            throw new EmployeeNotFoundException("employee not found: " + id);

        return entityManager.find(Employee.class, id);
    }

    @Override
    //@Transactional service kısmında
    public ResponseEntity<Employee> save(Employee employee) {
        if (employee.getFirstName() == null || employee.getEmail() == null || employee.getLastName() == null)
            throw new EmployeeBadRequestException("hatalı body: ");
        entityManager.merge(employee); //if id==0 save, if id!=0 update
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @Override
    //@Transactional service kısmında
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee == null)
            throw new EmployeeNotFoundException("student not found" + id);
        entityManager.remove(employee);
    }

    @Override
    public List<Employee> sortByName() {
        return entityManager.createQuery("from Employee order by firstName", Employee.class).getResultList();
    }

}
