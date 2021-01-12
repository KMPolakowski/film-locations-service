package com.kmp.cicchallenge.repository;

import com.kmp.cicchallenge.model.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FilmRepository extends CrudRepository<Film, Long> {

    Optional<Film> findByName(String title);

}
