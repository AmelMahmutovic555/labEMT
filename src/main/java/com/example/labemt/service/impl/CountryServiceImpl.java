package com.example.labemt.service.impl;

import com.example.labemt.model.Country;
import com.example.labemt.repository.CountryRepository;
import com.example.labemt.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
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
        countryRepository.findById(id).map(existingAuthor -> {
            if (country.getName()!=null){
                existingAuthor.setName(country.getName());
            }
            if (country.getContinent()!=null){
                existingAuthor.setContinent(existingAuthor.getContinent());
            }
            return countryRepository.save(existingAuthor);
        });
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}
