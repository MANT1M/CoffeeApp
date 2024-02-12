package com.example.Coffee.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/")
    public String orders(){
        return "orders";
    }


}
