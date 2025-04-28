package com.example.labemt.service.application.impl;

import com.example.labemt.model.dto.CreateCountryDto;
import com.example.labemt.model.dto.DisplayCountryDto;
import com.example.labemt.service.application.CountryApplicationService;
import com.example.labemt.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryApplicationServiceImpl implements CountryApplicationService {
    private final CountryService countryService;

    public CountryApplicationServiceImpl(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public List<DisplayCountryDto> listAll() {
        return DisplayCountryDto.from(countryService.listAll());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryService.findById(id).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> create(CreateCountryDto createCountryDto) {
        return countryService.save(createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto) {
        return countryService.edit(id, createCountryDto.toCountry()).map(DisplayCountryDto::from);
    }

    @Override
    public void delete(Long id) {
        countryService.delete(id);
    }
}
