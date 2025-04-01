package com.example.labemt.service.application;

import com.example.labemt.model.dto.CreateCountryDto;
import com.example.labemt.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<DisplayCountryDto> listAll();
    Optional<DisplayCountryDto> create(CreateCountryDto createCountryDto);
    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);
}
