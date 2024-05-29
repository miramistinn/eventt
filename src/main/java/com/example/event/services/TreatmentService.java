package com.example.event.services;

import com.example.event.repository.TreatmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TreatmentService {
    private TreatmentRepository treatmentRepository;

}
