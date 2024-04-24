package com.example.event.services;

import com.example.event.dto.AdminDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.entity.Admin;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.repository.AdminRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminService {

    private final AdminRepository adminRepository;

    public Admin create(AdminDTO dto) {
        System.out.println(dto.getEmail() + "   " + dto.getPassword());
        return adminRepository.save(Admin.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .active(true)
                .build());
    }

    public List<Admin> readAll() {
        return adminRepository.findAll();
    }

    public Admin update(Admin admin) {
        return adminRepository.save(admin);
    }

    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}
