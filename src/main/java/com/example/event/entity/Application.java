package com.example.event.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "applications")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "comments")
    private String comments;
    @Column(name = "status")
    private String status;
    @Column(name = "source")
    private String source;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    private LocalDateTime dateOfCreated;
    @PrePersist//указывается что метод выаолняется перед сохранением сущности
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }
}
