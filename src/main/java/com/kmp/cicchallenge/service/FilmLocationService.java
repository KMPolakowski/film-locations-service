package com.kmp.cicchallenge.service;

import com.kmp.cicchallenge.domain.FilmLocation;
import com.kmp.cicchallenge.model.Film;
import com.kmp.cicchallenge.model.Location;
import com.kmp.cicchallenge.repository.FilmRepository;
import com.kmp.cicchallenge.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class FilmLocationService {

    private LocationRepository locationRepository;

    private FilmRepository filmRepository;

    public FilmLocationService(LocationRepository locationRepository, FilmRepository filmRepository, RestTemplate template) {
        this.locationRepository = locationRepository;
        this.filmRepository = filmRepository;
    }

    public void persistFilmLocations(FilmLocation[] filmLocations)
    {
        for (FilmLocation filmLocation : filmLocations) {
            Optional<Film> filmOptional = filmRepository.findByName(filmLocation.getTitle());
            Optional<Location> locationOptional = locationRepository.findByName(filmLocation.getLocations());

            Film film = null;

            if (filmOptional.isEmpty()) {
                film = new Film();
                film.setName(filmLocation.getTitle());
            } else {
                film = filmOptional.get();
            }

            Location location = null;

            if (locationOptional.isEmpty()) {
                location = new Location();
                location.setName(filmLocation.getLocations());
            } else {
                location = locationOptional.get();
            }

            film.getLocations().add(location);
            location.getFilms().add(film);

            filmRepository.save(film);
            locationRepository.save(location);
        }
    }
}
