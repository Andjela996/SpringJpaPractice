package com.example.demo2.repos;

import com.example.demo2.models.Paradigm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParRepo extends JpaRepository<Paradigm, Long> {
}
