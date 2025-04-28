package com.example.labemt.web;

import com.example.labemt.model.dto.CreateCountryDto;
import com.example.labemt.model.dto.DisplayCountryDto;
import com.example.labemt.service.application.CountryApplicationService;
import com.example.labemt.service.domain.CountryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    private final CountryApplicationService countryApplicationService;
    private final CountryService countryService;

    public CountryController(CountryApplicationService countryApplicationService, CountryService countryService) {
        this.countryApplicationService = countryApplicationService;
        this.countryService = countryService;
    }

    @Operation(summary = "Get a list of all countries", description = "Retrieves all countries from the system")
    @GetMapping
    public List<DisplayCountryDto> findAll() {
        return countryApplicationService.listAll();
    }

    @Operation(summary = "Find a country by id", description = "Finds a country by it's id")
    @GetMapping("/{id}")
    public ResponseEntity<DisplayCountryDto> findById(@PathVariable Long id){
        return countryApplicationService.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
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

    @Operation(summary = "Delete a country by ID", description = "Deletes the country with the given ID from the system")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (countryService.findById(id).isPresent()) {
            countryService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
