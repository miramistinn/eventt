package com.example.event.repository;

import com.example.event.entity.Application;
import com.example.event.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {
   // List<Buy> findByEmail(String email);
    List<Application> findByClient_Id(Long id);

}
