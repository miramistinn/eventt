package com.example.event.controllers;

import com.example.event.dto.ClientDTO;
import com.example.event.entity.Client;
import com.example.event.entity.User;
import com.example.event.services.AdminService;
import com.example.event.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@AllArgsConstructor
public class LogControler {
    private final ClientService clientService;
    private final AdminService adminService;

    @PostMapping("/log/create")
    public ResponseEntity<?> create(@RequestBody ClientDTO dto) {
        if (clientService.checkIfExistClient(dto) == null && adminService.checkIfExistAdmin(dto) == null) {
            User.getInstance().setAdmin(false);
            User.getInstance().setEmail(dto.getEmail());
            return new ResponseEntity<>(clientService.create(dto), HttpStatus.OK);
        } else {
            String errorMessage = "Пользователь уже существует";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }

    }

    @PostMapping("/log/check")
    public ResponseEntity<?> logCheck() {
        User user = User.getInstance();
        System.out.println(user.getEmail());
        if (Objects.equals(user.getEmail(), "")) return ResponseEntity.ok("no");
        else if (clientService.haveBuy(user.getEmail())) return ResponseEntity.ok("client have");
        else if (!clientService.haveBuy(user.getEmail())) return ResponseEntity.ok("client");
        return ResponseEntity.ok("admin");
    }

    @PostMapping("/log/logIn")
    public ResponseEntity<?> logIn(@RequestBody ClientDTO dto) {
        if (clientService.checkIfExistClient(dto) != null) {
//            if (adminService.checkIfBun(dto)==null){
//                String errorMessage = "bun";
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
//            }
            User user = User.getInstance();
            user.setEmail(dto.getEmail());
            user.setAdmin(false);
            return ResponseEntity.ok("client");
        }
        if (adminService.checkIfExistAdmin(dto) != null) {
//            if (adminService.checkIfBun(dto)==null){
//                String errorMessage = "bun";
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
//            }
            User user = User.getInstance();
            user.setEmail(dto.getEmail());
            user.setAdmin(true);
            return ResponseEntity.ok("admin");
        } else {
            String errorMessage = "Пользователя не существует";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PostMapping("/log/logOut")
    public HttpStatus logOut() {
        System.out.println("пользователь вышел из аккаунта");
        User.getInstance().setEmail("");
        User.getInstance().setAdmin(false);
        return HttpStatus.OK;
    }

    @GetMapping("/read/client")
    public ResponseEntity<List<Client>> readAll() {
        return new ResponseEntity<>(clientService.readAll(), HttpStatus.OK);
    }

}
