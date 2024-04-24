package com.example.event.controllers;

import com.example.event.dto.AdminDTO;
import com.example.event.dto.ApplicationDTO;
import com.example.event.entity.Admin;
import com.example.event.entity.Application;
import com.example.event.services.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create/admin")
    public ResponseEntity<Admin> create(@RequestBody AdminDTO dto){
        return new ResponseEntity<>(adminService.create(dto), HttpStatus.OK);
    }
//
//    @GetMapping
//    public ResponseEntity<List<Admin>> readAllAdmin(){
//        return new ResponseEntity<>(adminService.readAll(), HttpStatus.OK);
//    }
//    @PutMapping
//    public ResponseEntity<Admin> update(@RequestBody Admin admin){
//        return new ResponseEntity<>(adminService.update(admin), HttpStatus.OK);
//    }
//    @DeleteMapping("/{id}")
//    public HttpStatus delete(@PathVariable Long id){
//        adminService.delete(id);
//        return HttpStatus.OK;
//    }
}
