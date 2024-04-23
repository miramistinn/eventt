package com.example.event.dto;

import com.example.event.entity.Client;
import lombok.Data;

@Data
public class ApplicationDTO {
    private String name;
    private String phone;
    private String comment;
    private Client client;
}
