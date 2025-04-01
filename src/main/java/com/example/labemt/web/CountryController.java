package com.example.labemt.web;

import com.example.labemt.model.dto.CreateCountryDto;
import com.example.labemt.model.dto.DisplayCountryDto;
import com.example.labemt.service.application.CountryApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryApplicationService countryApplicationService;

    public CountryController(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @Operation(summary = "Get a list of all countries", description = "Retrieves all countries from the system")
    @GetMapping
    public List<DisplayCountryDto> findAll() {
        return countryApplicationService.listAll();
    }

    @Operation(summary = "Create a new country", description = "Creates a new country and returns the created country data")
    @PostMapping("/add")
    public ResponseEntity<DisplayCountryDto> save(@RequestBody CreateCountryDto createCountryDto) {
        return countryApplicationService.create(createCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an existing country", description = "Updates a country with the given ID and new data")
    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayCountryDto> update(@PathVariable Long id, @RequestBody CreateCountryDto createCountryDto) {
        return countryApplicationService.update(id, createCountryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
