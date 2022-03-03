package com.example.demo2.services;


import com.example.demo2.models.Language;
import com.example.demo2.models.Paradigm;
import com.example.demo2.repos.LangRepo;
import com.example.demo2.repos.ParRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParServiceImpl implements ParService {

    @Autowired
    ParRepo parRepo;

    @Autowired
    LangRepo langRepo;

    @Override
    public List<Paradigm> getAllPars() {
        return parRepo.findAll();
    }

    @Override
    public void editOrNewPar(Paradigm paradigm) {
        parRepo.save(paradigm);
    }

    @Override
    public void deletePar(Long id) {
        List<Language> langs = langRepo.findAll();
        for(Language l: langs){
            l.getParadigmSet().remove(parRepo.getById(id));
        }
        parRepo.deleteById(id);
    }

    @Override
    public Paradigm getPar(Long id) {
        return parRepo.findById(id).get();
    }
}
