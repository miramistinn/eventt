package com.example.event.controllers;

import com.example.event.dto.ApplicationDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@AllArgsConstructor
public class ClientControler {
    private final ClientService clientService;
    @PostMapping("/create")
    public ResponseEntity<Client> create(@RequestBody ClientDTO dto){
        System.out.println("mkmkmkmkm");
        return new ResponseEntity<>(clientService.create(dto), HttpStatus.OK);
    }
    @GetMapping("/read/client")
    public ResponseEntity<List<Client>> readAll(){
        return new ResponseEntity<>(clientService.readAll(), HttpStatus.OK);
    }
}
