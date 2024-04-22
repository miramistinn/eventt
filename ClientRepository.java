package com.example.event.repository;

import com.example.event.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public class ClientRepository extends JpaRepository<Client, Long> {
List<Client> findById(Long id);
}
