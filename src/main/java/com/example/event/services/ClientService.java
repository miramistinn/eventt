package com.example.event.services;

import com.example.event.dto.ClientDTO;
import com.example.event.entity.Client;
import com.example.event.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(ClientDTO dto){
        return clientRepository.save(Client.builder()
                .email(dto.getEmail())
                .password(dto.getPassworld())
                .build());
    }
}
