package com.example.labemt.service.domain;

import com.example.labemt.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> listAll();
    Optional<Country> findById(Long id);
    Optional<Country> save(Country book);
    Optional<Country> edit(Long id, Country country);
    void delete(Long id);
}
