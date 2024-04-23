package com.example.event.dto;

import lombok.Data;
//это дял передачи данныхв запрос
@Data
public class ClientDTO {
    private String email;
    private String passworld;
}
