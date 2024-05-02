package com.example.event.repository;

import com.example.event.entity.Admin;
import com.example.event.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    Client findByEmail(String email);
}
