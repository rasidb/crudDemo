package com.luv2code.springboot.thymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;


    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String dataEnteredByTheUser, ConstraintValidatorContext constraintValidatorContext) {
        return dataEnteredByTheUser != null;
    }
}
