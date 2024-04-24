package com.example.event.services;

import com.example.event.dto.ClientDTO;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(ClientDTO dto) {
        System.out.println(dto.getEmail() +"   "+ dto.getPassword());
        return clientRepository.save(Client.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .active(true)
                .haveBuy(false)
                .build());

    }
    public List<Client> readAll() {
        return clientRepository.findAll();
    }
    public Client readById(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Client is not found - " + id));
    }
}
