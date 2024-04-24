package com.example.event.controllers;

import com.example.event.dto.ApplicationDTO;
import com.example.event.entity.Application;
import com.example.event.services.ApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ApplicationController {
    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<Application> create(@RequestBody ApplicationDTO dto){
        return new ResponseEntity<>(applicationService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Application>> readAll(){
        return new ResponseEntity<>(applicationService.readAllApplication(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Application> update(@RequestBody Application application){
        return new ResponseEntity<>(applicationService.update(application), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
        applicationService.delete(id);
        return HttpStatus.OK;
    }

}
