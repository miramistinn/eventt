package com.example.event.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class SmetaDTO {
    private Long TreatmentId;
    private Long id;
    private String category;
    private String name;
    private Double expenses;
}
