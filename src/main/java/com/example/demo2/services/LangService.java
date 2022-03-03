package com.example.demo2.services;

import com.example.demo2.models.Language;

import java.util.List;

public interface LangService {
    List<Language> getAllLangs();
    void editOrNewLang(Language language);
    void deleteLang(Long id);
    Language getLang(Long id);
}
