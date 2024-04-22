package com.example.event.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller
public class ClientControllers {
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }
    @GetMapping("/zayavka")
    public ModelAndView zayavka() {
        ModelAndView modelAndView = new ModelAndView("zayavka");
        return modelAndView;
    }
    @GetMapping("/reg")
    public ModelAndView reg() {
        ModelAndView modelAndView = new ModelAndView("reg");
        return modelAndView;
    }
    @GetMapping("/ab")
    public ModelAndView ab() {
        ModelAndView modelAndView = new ModelAndView("ab");
        return modelAndView;
    }
    @GetMapping("/con")
    public ModelAndView con() {
        ModelAndView modelAndView = new ModelAndView("qwe");
        return modelAndView;
    }
    @GetMapping("/log")
    public ModelAndView log() {
        ModelAndView modelAndView = new ModelAndView("log");
        return modelAndView;
    }

}
