package com.example.event.services;

import com.example.event.dto.ApplicationDTO;
import com.example.event.dto.ClientDTO;
import com.example.event.dto.RejectDTO;
import com.example.event.entity.*;
import com.example.event.repository.RejectedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RejectService {
    private RejectedRepository rejectedRepository;
    private ApplicationService applicationService;
    private AdminService adminService;

    public Rejected rejected(RejectDTO dto) {
        Application application = applicationService.readById(dto.getId());
        User user = User.getInstance();
        Admin admin = adminService.readByEmail(user.getEmail());
        return rejectedRepository.save(Rejected.builder().
                name(application.getName())
                .phone(application.getPhone())
                .status("rejected")
                .admin(admin)
                .source(application.getSource())
                .commentByAdmin(dto.getCommentByAdmin())
                .comments(application.getComments())
                .build());
    }
    public List<Rejected> readAllRejected() {
        return  rejectedRepository.findAll();

    }
}
