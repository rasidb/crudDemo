package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class StudentController {

    @GetMapping("/showStudent")
    public String showStudent(Model model){
        //create a student object
        Student student =new Student();
        //add the object to model
        model.addAttribute("student",student);
        return "student-form";
    }

@GetMapping("/processStudentForm")
    public String studentForm(@ModelAttribute("student") Student student){
    System.out.println(student.getFirstName());
    System.out.println(student.getLastName());
    return "student-form.html";
}
}
