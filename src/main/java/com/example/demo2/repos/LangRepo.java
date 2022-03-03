package com.example.demo2.repos;

import com.example.demo2.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LangRepo extends JpaRepository<Language, Long> {
}
