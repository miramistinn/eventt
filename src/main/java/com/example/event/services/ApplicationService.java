package com.example.event.services;

import com.example.event.dto.ApplicationDTO;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.entity.User;
import com.example.event.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ClientService clientService;

    public Application create(ApplicationDTO dto) {
        clientService.clientHadApp();
        User user = User.getInstance();
        Client client = clientService.readByEmail(user.getEmail());
        return applicationRepository.save(Application.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .comments(dto.getComments())
                .client(client)
                .source(dto.getSource())
                .status("new")
                .dateOfCreated(dto.getDateOfCreated())
                .build());

    }

    public Application createAdmin(ApplicationDTO dto) {
        return applicationRepository.save(Application.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .comments(dto.getComments())
                .source(dto.getSource())
                .status("new")
                .dateOfCreated(dto.getDateOfCreated())
                .build());

    }


    public List<Application> readAllApplication() {
        return applicationRepository.findAll();
    }

    public List<Application> readByEmail() {
        User user = User.getInstance();
        return applicationRepository.findByClient_Id(clientService.readByEmail(user.getEmail()).getId());
    }

    public Application readById(Long id) {
        return applicationRepository.findById(id).orElseThrow();
    }

    public List<Application> readByClientId(Long id) {
        return applicationRepository.findByClient_Id(id);
    }

    public Application update(Application application) {
        return applicationRepository.save(application);
    }

    public void delete(Long id) {
        applicationRepository.deleteById(id);
    }

}
