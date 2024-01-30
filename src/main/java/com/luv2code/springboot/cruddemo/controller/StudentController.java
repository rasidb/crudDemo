package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;


    @GetMapping("/showStudent")
    public String showStudent(Model model) {
        System.out.println(countries.size());
        //create a student object
        Student student = new Student();
        //add the object to model
        model.addAttribute("student", student);
        model.addAttribute("countries",countries);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String studentForm(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("isim", student.getFirstName());
        model.addAttribute("soyisim", student.getLastName());
        model.addAttribute("country", student.getCountry());
        return "student";
    }





    @Value("${countries}")
    private List<String> country;


    @PostMapping("/showStudent")
    public String show(Model model){
        Student student =new Student();
        model.addAttribute("student",student);
        model.addAttribute("country",countries);
        return "student-form";
    }













}
