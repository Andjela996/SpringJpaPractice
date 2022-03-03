package com.example.demo2.services;

import com.example.demo2.models.Language;
import com.example.demo2.repos.LangRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LangServiceImpl implements LangService {

    @Autowired
    LangRepo langRepo;

    @Override
    public List<Language> getAllLangs() {
        return langRepo.findAll();
    }

    @Override
    public void editOrNewLang(Language language) {
        langRepo.save(language);
    }

    @Override
    public void deleteLang(Long id) {
        langRepo.deleteById(id);
    }

    @Override
    public Language getLang(Long id) {
        return langRepo.findById(id).get();
    }
}
