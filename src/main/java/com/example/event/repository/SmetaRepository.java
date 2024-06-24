package com.example.event.repository;

import com.example.event.entity.Smeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmetaRepository extends JpaRepository<Smeta, Long> {
    List <Smeta> findByTreatment_Id(Long id);
}
