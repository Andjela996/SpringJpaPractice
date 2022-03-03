package com.example.demo2.models;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Paradigm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "paradigmSet")
    private Set<Language> languageSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Language> getLanguageSet() {
        return languageSet;
    }

    public void setLanguageSet(Set<Language> languageSet) {
        this.languageSet = languageSet;
    }
}
