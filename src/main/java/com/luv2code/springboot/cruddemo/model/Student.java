package com.luv2code.springboot.cruddemo.model;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Student {
    @Min(value = 1,message = "en düşük 1 olmalı")
    @Max(value = 30,message = "en yüksek 30 olmalı")
    private int age;

    @NotNull(message = "is required")
    @Size(min = 1,message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName="";

    private String country;

    private String language;

    private List<String> operatingSystem;

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
