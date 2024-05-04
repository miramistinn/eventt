package com.example.event.controllers;

import com.example.event.dto.AdminDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.entity.Client;
import com.example.event.services.AdminService;
import com.example.event.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@AllArgsConstructor
public class LogControler {
    private final ClientService clientService;
    private final AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ClientDTO dto) {
        System.out.println("mkmkmkmkm");
        if (clientService.checkIfExistClient(dto) == null && adminService.checkIfExistAdmin(dto) == null) {
            return new ResponseEntity<>(clientService.create(dto), HttpStatus.OK);
        }
        else {
            String errorMessage = "Пользователь уже существует";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

    }

    @GetMapping("/read/client")
    public ResponseEntity<List<Client>> readAll() {
        return new ResponseEntity<>(clientService.readAll(), HttpStatus.OK);
    }
}
