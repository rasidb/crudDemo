package com.luv2code.springboot.thymeleaf.controller;

import com.luv2code.springboot.thymeleaf.model.Employee;
import com.luv2code.springboot.thymeleaf.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor); //stringTrimmerEditor sayesinde inputta bulunan boşlukları siliyoruz
    }

    @Value("${countries}")
    private List<String> countries;

    @Autowired
    private EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listOfEmployees(Model model) {
        //get the employees from db
        List<Employee> employees = employeeService.sortByName();
        //add to spring model
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String addEmployee(Model model) {
        model.addAttribute("countries", countries);
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";


    }

    @PostMapping("/save")
    public String saveEmployee(Model model, @ModelAttribute("employee") @Valid Employee employee, BindingResult bindingResult) {
        model.addAttribute("countries", countries);
        if (bindingResult.hasErrors())
            return "employees/employee-form";
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String update(@RequestParam("employeeId") String id, Model model) {
        Employee employee = employeeService.findByID(id);
        model.addAttribute("employee", employee);
        model.addAttribute("countries", countries);
        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") String id) {
        employeeService.deleteById(id);
        return "redirect:/employees/list";

    }
    @GetMapping("/showLoginPage")
    public String loginPage(){
        return "plain-login";
    }
}



