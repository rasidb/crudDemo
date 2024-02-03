package com.luv2code.springboot.cruddemo.model;


import jakarta.validation.constraints.*;

import java.util.List;

public class Student {
    @Min(value = 1,message = "en düşük 1 olmalı")
    @Max(value = 30,message = "en yüksek 30 olmalı")
    @NotNull(message = "is required")
    private Integer age;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName="";

    @Pattern(regexp = "^[a-zA-Z0-9]{5}",message = "5 karakter olmalı")
    private String postalCode;

    private String country;

    private String language;

    private List<String> operatingSystem;

    public Student() {
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public List<String> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(List<String> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
