package com.example.labemt.model.dto;

import com.example.labemt.model.domain.Country;

public record CreateCountryDto(String name, String continent) {
    public Country toCountry(){
        return new Country(name, continent);
    }
}
