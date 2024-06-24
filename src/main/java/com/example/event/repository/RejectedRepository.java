package com.example.event.repository;

import com.example.event.entity.Rejected;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.nio.file.FileStore;

@Repository
public interface RejectedRepository extends JpaRepository<Rejected, Long> {

}
