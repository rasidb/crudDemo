package com.luv2code.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
@RequestMapping("/processForm2")
    public String letShoutDude(HttpServletRequest request, Model model) {
        //html formundaki istekleri oku
        String studentName = request.getParameter("studentName");
        //hepsini büyük harfe çevir
        //mesajı oluştur
        String result = "yo! " + studentName.toUpperCase();
        //mesajı modele ekle
        model.addAttribute("message",result);
        return "helloworld";

    }
@PostMapping("/processForm3")
    public String letShoutDude(@RequestParam("patates")String name,Model model){
    String result =name.toUpperCase();
    model.addAttribute("soğan",result);
    return "helloworld";
}
}