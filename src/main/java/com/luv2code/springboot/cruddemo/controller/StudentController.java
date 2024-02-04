package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.model.Student;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @InitBinder //formdan gelen verileri temizlemek ya da özel dönüşümler için kullanılır
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor =new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor); //stringTrimmerEditor sayesinde inputta bulunan boşlukları siliyoruz
    }


    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;
    @Value("${operatingSystems}")
    private List<String> operatingSystems;


    @GetMapping("/showStudent")
    public String showStudent(Model model) {
        //add the object to model
        model.addAttribute("student", new Student());
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("operatingSystems", operatingSystems);
        return "student-form";
    }

    /**
     * @param bindingResult önce bu classtan objeyi ekle sonra modeli ekle yoksa bindingResult hatayı görmüyor
     * @param model
     * @return
     */
   @PostMapping("/processStudentForm")
   public String studentForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
       System.out.println(bindingResult.toString());
       if (bindingResult.hasErrors()) {
           return "student-form";
       }
       model.addAttribute("isim", student.getFirstName());
       model.addAttribute("soyisim", student.getLastName());
       model.addAttribute("yaş",student.getAge());
       model.addAttribute("postalCode",student.getPostalCode());
       model.addAttribute("country", student.getCountry());
       model.addAttribute("language", student.getLanguage());
       model.addAttribute("operatingSystem", student.getOperatingSystem());
    model.addAttribute("courseCode",student.getCourseCode());
       return "student";
   }



    @Value("${countries}")
    private List<String> country;

    @PostMapping("/showStudent")
    public String show(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        model.addAttribute("country", countries);
        return "student-form";
    }


}
