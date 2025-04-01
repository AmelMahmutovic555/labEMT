package com.example.labemt.service.application.impl;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.domain.Country;
import com.example.labemt.model.dto.CreateAuthorDto;
import com.example.labemt.model.dto.CreateBookDto;
import com.example.labemt.service.application.AuthorApplicationService;
import com.example.labemt.service.domain.AuthorService;
import com.example.labemt.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorApplicationServiceImpl implements AuthorApplicationService {
    private final AuthorService authorService;
    private final CountryService countryService;

    public AuthorApplicationServiceImpl(AuthorService authorService, CountryService countryService) {
        this.authorService = authorService;
        this.countryService = countryService;
    }


    @Override
    public List<CreateAuthorDto> listAll() {
        return CreateAuthorDto.from(authorService.listAll());
    }

    @Override
    public Optional<CreateAuthorDto> create(CreateAuthorDto createAuthorDto) {
        Country country = countryService.findById(createAuthorDto.country()).orElse(null);
        return authorService.save(createAuthorDto.toAuthor(country)).map(CreateAuthorDto::from);
    }

    @Override
    public Optional<CreateAuthorDto> update(Long id, CreateAuthorDto createAuthorDto) {
        Country country = countryService.findById(createAuthorDto.country()).orElse(null);
        return authorService.edit(id, createAuthorDto.toAuthor(country)).map(CreateAuthorDto::from);
    }
}
