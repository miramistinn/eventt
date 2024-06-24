package com.example.event.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "smeta")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Smeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "category")
    private String category;
    @Column(name = "name")
    private String name;
    @Column(name = "expenses")
    private Double expenses;
    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;
}
