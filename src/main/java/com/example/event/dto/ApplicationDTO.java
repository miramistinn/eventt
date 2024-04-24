package com.example.event.dto;

import com.example.event.entity.Client;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDTO {
    private String name;
    private String phone;
    private String comments;
    private Long clientId;
    private LocalDateTime dateOfCreated;
}
