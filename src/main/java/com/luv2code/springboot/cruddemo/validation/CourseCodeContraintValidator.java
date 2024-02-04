package com.luv2code.springboot.cruddemo.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.annotation.Annotation;

public class CourseCodeContraintValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String dataEnteredByTheUser, ConstraintValidatorContext constraintValidatorContext) {
        boolean result;
        result= dataEnteredByTheUser != null;

        return result;
    }
}
