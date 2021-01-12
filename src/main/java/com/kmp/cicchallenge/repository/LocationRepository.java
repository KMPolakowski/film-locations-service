package com.kmp.cicchallenge.repository;

import com.kmp.cicchallenge.model.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location, Long> {

    Optional<Location> findByName(String name);
}
