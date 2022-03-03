package com.example.demo2.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int year;

    @ManyToMany
    @JoinTable(
            name = "lang_paradigm",
            joinColumns = @JoinColumn(name = "lang_id"),
            inverseJoinColumns = @JoinColumn(name = "par_id"))
    private Set<Paradigm> paradigmSet;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Paradigm> getParadigmSet() {
        return paradigmSet;
    }

    public void setParadigmSet(Set<Paradigm> paradigmSet) {
        this.paradigmSet = paradigmSet;
    }
}
