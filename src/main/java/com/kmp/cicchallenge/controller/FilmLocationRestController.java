package com.kmp.cicchallenge.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.kmp.cicchallenge.domain.FilmLocation;
import com.kmp.cicchallenge.model.Film;
import com.kmp.cicchallenge.model.Location;
import com.kmp.cicchallenge.repository.FilmRepository;
import com.kmp.cicchallenge.repository.LocationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class FilmLocationRestController {

    private final FilmRepository filmRepo;

    public FilmLocationRestController(FilmRepository filmRepo) {
        this.filmRepo = filmRepo;
    }

    @GetMapping("/films")
    public Iterable<Film> getFilmLocations(
            @RequestParam(value = "title", required = false) String filmTitle
    ) {
        if (filmTitle != null && !filmTitle.isEmpty()) {
            ArrayList<Film> films = new ArrayList<>();

            try {
                Film film = filmRepo.findByName(filmTitle).get();
                films.add(film);
                return films;
            } catch (NoSuchElementException e) {
                return films;
            }
        }

        return filmRepo.findAll();
    }
}

