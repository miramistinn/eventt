package com.example.event.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "clients")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "password", length = 1000)
    private String password;
    @Column(name = "haveEvent")
    private boolean haveBuy;
    @Column(name = "active")
    private boolean active;
}
