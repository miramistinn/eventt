package com.example.event.repository;

import com.example.event.entity.Smeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmetaRepository extends JpaRepository<Smeta, Long> {
}
