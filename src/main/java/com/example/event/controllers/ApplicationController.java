package com.example.event.controllers;

import com.example.event.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

//    @PostMapping
//public
}
