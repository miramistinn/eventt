package com.example.event.services;

import com.example.event.dto.ApplicationDTO;
import com.example.event.entity.Application;
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
        return applicationRepository.save(Application.builder()
                .name(dto.getName())
                .phone(dto.getPhone())
                .comments(dto.getComments())
                //.client(clientService.readById(dto.getClientId()))
                .dateOfCreated(dto.getDateOfCreated())
                .build());

    }

    public List<Application> readAllApplication() {
        return applicationRepository.findAll();
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
