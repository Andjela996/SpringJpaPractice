package com.example.demo2.services;

import com.example.demo2.models.Paradigm;

import java.util.List;

public interface ParService {
    List<Paradigm> getAllPars();
    void editOrNewPar(Paradigm paradigm);
    void deletePar(Long id);
    Paradigm getPar(Long id);
}
