//package com.example.event.entity;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@Table(name = "schedule")
//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class Schedule {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//    @Column(name = "status")
//    private String status;
//    @OneToOne
//    @JoinColumn(name = "applications_id")
//    private Application application;
//}
