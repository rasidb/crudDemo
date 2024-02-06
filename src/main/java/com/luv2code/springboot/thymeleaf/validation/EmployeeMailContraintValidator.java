package com.luv2code.springboot.thymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmployeeMailContraintValidator implements ConstraintValidator<EmployeeMail, String> {
    private String coursePrefix;


    @Override
    public void initialize(EmployeeMail employeeMail) {
        coursePrefix = employeeMail.value();
    }

    @Override
    public boolean isValid(String dataEnteredByTheUser, ConstraintValidatorContext constraintValidatorContext) {
      if (dataEnteredByTheUser==null){
          return false;
      }
      return dataEnteredByTheUser.endsWith(coursePrefix);
    }

}
