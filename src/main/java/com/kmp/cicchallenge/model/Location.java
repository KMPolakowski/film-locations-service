package com.kmp.cicchallenge.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_location",
            joinColumns = @JoinColumn(
                    name = "location_id"
            ),
            inverseJoinColumns = @JoinColumn(name="film_id")
    )

    @JsonBackReference
    private Set<Film> films = new HashSet<>();

    public Location() {
    }

    public Location(Long id, String name, Set<Film> films) {
        this.id = id;
        this.name = name;
        this.films = films;
    }

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

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
