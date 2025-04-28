package com.example.labemt.service.domain.impl;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.domain.Country;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.CountryRepository;
import com.example.labemt.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final AuthorRepository authorRepository;

    public CountryServiceImpl(CountryRepository countryRepository, AuthorRepository authorRepository) {
        this.countryRepository = countryRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Country> listAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Optional<Country> save(Country book) {
        return Optional.of(countryRepository.save(book));
    }

    @Override
    public Optional<Country> edit(Long id, Country country) {
        Optional<Country> existingCountry = countryRepository.findById(id);
        if (existingCountry.isPresent()) {
            Country updatedCountry = existingCountry.get();
            if (country.getName() != null) {
                updatedCountry.setName(country.getName());
            }
            if (country.getContinent() != null) {
                updatedCountry.setContinent(country.getContinent());
            }
            return Optional.of(countryRepository.save(updatedCountry));
        }
        return Optional.empty(); // If country is not found
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
