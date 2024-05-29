package com.example.event.controllers;

import com.example.event.dto.AdminDTO;
import com.example.event.dto.ApplicationDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.entity.Admin;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.entity.User;
import com.example.event.services.AdminService;
import com.example.event.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AdminController {
private final ClientService  clientService;
    private final AdminService adminService;

    @PostMapping("/create/admin")
    public ResponseEntity<?> create(@RequestBody ClientDTO dto){
        if (clientService.checkIfExistClient(dto) == null && adminService.checkIfExistAdmin(dto) == null) {
            return new ResponseEntity<>(adminService.createAdmin(dto), HttpStatus.OK);
        }
        else {
            String errorMessage = "Пользователь уже существует";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @GetMapping("/read/admin")
    public ResponseEntity<List<Admin>> readAll() {
        return new ResponseEntity<>(adminService.readAll(), HttpStatus.OK);
    }
    @PostMapping("/client/ban")
    public HttpStatus clientBun(@RequestBody String email){
        System.out.println(email);
        adminService.clientBan(email);
        return  HttpStatus.OK;
    }
    @PostMapping("/admin/ban")
    public HttpStatus adminBun(@RequestBody String email){
        adminService.clientBan(email);
        return  HttpStatus.OK;
    }
}
