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

    @PostMapping("create/application")
    public ResponseEntity<Application> create(@RequestBody ApplicationDTO dto){
       dto.setSource("site");
       return new ResponseEntity<>(applicationService.create(dto), HttpStatus.OK);
    }
    @PostMapping("create/application/admin")
    public ResponseEntity<Application> createAdmin(@RequestBody ApplicationDTO dto){
        return new ResponseEntity<>(applicationService.createAdmin(dto), HttpStatus.OK);
    }
    @GetMapping("application/readAll")
    public ResponseEntity<List<Application>> readAll(){
        return new ResponseEntity<>(applicationService.readAllApplication(), HttpStatus.OK);
    }
    @GetMapping("application/readByEmail")
    public ResponseEntity<List<Application>> readByEmail(){
        return new ResponseEntity<>(applicationService.readByEmail(), HttpStatus.OK);
    }
    @PostMapping("application/readByID/{id}")
    public ResponseEntity<Application> readById(@PathVariable Long id){
        System.out.println(id);
        System.out.println("dfjghdfhgslhfwlehflhef");
        return new ResponseEntity<>(applicationService.readById(id), HttpStatus.OK);
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
