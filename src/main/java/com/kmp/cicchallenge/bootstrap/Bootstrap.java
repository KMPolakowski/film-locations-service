package com.kmp.cicchallenge.bootstrap;

import com.kmp.cicchallenge.domain.FilmLocation;
import com.kmp.cicchallenge.model.Film;
import com.kmp.cicchallenge.model.Location;
import com.kmp.cicchallenge.repository.FilmRepository;
import com.kmp.cicchallenge.repository.LocationRepository;
import com.kmp.cicchallenge.service.FilmLocationClient;
import com.kmp.cicchallenge.service.FilmLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class Bootstrap implements CommandLineRunner {

    private final FilmLocationService filmLocationService;
    private final FilmLocationClient filmLocationClient;

    public Bootstrap(FilmLocationService filmLocationService, FilmLocationClient filmLocationClient) {
        this.filmLocationService = filmLocationService;
        this.filmLocationClient = filmLocationClient;
    }

    @Override
    public void run(String... args) throws Exception {
        filmLocationService.persistFilmLocations(
                filmLocationClient.fetchFilmLocations()
        );
    }
}
