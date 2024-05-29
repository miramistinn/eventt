package com.example.event.services;

import com.example.event.dto.AdminDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.entity.User;
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
                .haveEvent(false)
                .build());

    }
    public Long checkIfExistClient(ClientDTO dto){
        if( clientRepository.findByEmail(dto.getEmail())==null)
            return null;
        else return  clientRepository.findByEmail(dto.getEmail()).getId();
    }
    public List<Client> readAll() {
        return clientRepository.findAll();
    }
    public Client readById(Long id) {
        return clientRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Client is not found - " + id));
    }
    public Client readByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
    public void clientHadApp(){
        User user = User.getInstance();
        clientRepository.findByEmail(user.getEmail()).setHaveEvent(true);

    }
    public Long checkIfBun(ClientDTO dto){
        if( !clientRepository.findByEmail(dto.getEmail()).isActive())
            return null;
        else return  clientRepository.findByEmail(dto.getEmail()).getId();
    }

    public boolean haveBuy(String email){
        return  clientRepository.findByEmail(email).isHaveEvent();
    }
}
