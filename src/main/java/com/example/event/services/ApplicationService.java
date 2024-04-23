package com.example.event.services;

import com.example.event.dto.ApplicationDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.repository.ApplicationRepository;
import com.example.event.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ClientRepository clientRepository;

    public Application create(ApplicationDTO dto) {
        return applicationRepository.save(Application.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .comments(dto.getComment())
                .client(dto.getClient())
                .build());

    }
    public List<Application> readAll(){
        return applicationRepository.findAll();
    }


}
