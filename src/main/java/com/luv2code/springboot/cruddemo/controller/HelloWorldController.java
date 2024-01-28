package com.luv2code.springboot.cruddemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HelloWorldController {
//html formunu göstermek için yeni method oluştur

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

            //html formunu işlemek için yeni bi method oluştur
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
}
