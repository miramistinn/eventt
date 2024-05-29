package com.example.event.services;

import com.example.event.dto.AdminDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.entity.Admin;
import com.example.event.entity.Application;
import com.example.event.entity.Client;
import com.example.event.entity.User;
import com.example.event.repository.AdminRepository;
import com.example.event.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class AdminService {
    private final ClientRepository clientRepository;
    private final AdminRepository adminRepository;

    public Admin createAdmin(ClientDTO dto) {
        System.out.println(dto.getEmail() + "   " + dto.getPassword());
        return adminRepository.save(Admin.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .active(true)
                .build());
    }
    public void clientBan(String email) {
        System.out.println(email);
        String modifiedStr = email.substring(1, email.length() - 1);
        System.out.println(modifiedStr);
        Client client = clientRepository.findByEmail(modifiedStr);

        if (client != null) {
            boolean isActive = client.isActive();
            client.setActive(!isActive);
            clientRepository.save(client);
            System.out.println(modifiedStr + " был изменен статус");
        } else {
            System.out.println("Клиент не найден");
        }
    }
    public void adminBan(String email) {
        System.out.println(email);
        String modifiedStr = email.substring(1, email.length() - 1);
        System.out.println(modifiedStr);
        Admin admin = adminRepository.findByEmail(modifiedStr);
        if (admin != null&& !Objects.equals(admin.getEmail(), User.getInstance().getEmail())) {
            boolean isActive = admin.isActive();
            admin.setActive(!isActive);
            adminRepository.save(admin);
            System.out.println(modifiedStr + " был изменен статус");
        } else {
            System.out.println("Беда");
        }
    }
    public Admin createAdmin(AdminDTO dto) {
        System.out.println(dto.getEmail() + "   " + dto.getPassword());
        return adminRepository.save(Admin.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .active(true)
                .build());
    }
    public Long checkIfExistAdmin(ClientDTO dto){
        if( adminRepository.findByEmail(dto.getEmail())==null)
            return null;
        else return  adminRepository.findByEmail(dto.getEmail()).getId();
    }
    public Long checkIfBun(ClientDTO dto){
        if( !adminRepository.findByEmail(dto.getEmail()).isActive())
            return null;
        else return  adminRepository.findByEmail(dto.getEmail()).getId();
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
    public Admin readByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

}
