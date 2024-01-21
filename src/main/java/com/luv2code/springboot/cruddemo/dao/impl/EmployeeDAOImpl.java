package com.luv2code.springboot.cruddemo.dao.impl;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    //Create an EntityManager object
    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    public List<Employee> findAll() {
        return  entityManager.createQuery("from Employee",Employee.class).getResultList();
    }

    @Override
    public Employee findByID(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    //@Transactional service kısmında
    public Employee save(Employee employee) {
        entityManager.merge(employee); //if id==0 save, if id!=0 update
        return employee;
    }

    @Override
    //@Transactional service kısmında
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }

}
