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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FilmLocationController {

    private final FilmRepository filmRepo;

    public FilmLocationController(FilmRepository filmRepo) {
        this.filmRepo = filmRepo;
    }

    @RequestMapping("/films/view")
    public String viewFilmLocation(Model model) {
        model.addAttribute("films", filmRepo.findAll());

        return "film_locations/list";
    }

}

