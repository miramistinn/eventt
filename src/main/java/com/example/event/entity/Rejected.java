package com.example.event.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Table(name = "rejected")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rejected {
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
    @JoinColumn(name = "admin_id")
    private Admin admin;
    @Column(name = "commentByAdmin")
    private String commentByAdmin;
    private LocalDateTime dateOfReject;
    @PrePersist//указывается что метод выаолняется перед сохранением сущности
    private void init() {
        dateOfReject = LocalDateTime.now();
    }

}
