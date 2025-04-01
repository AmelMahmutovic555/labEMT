package com.example.labemt.service.application;

import com.example.labemt.model.dto.CreateBookDto;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    List<CreateBookDto> listAll();
    Optional<CreateBookDto> create(CreateBookDto createBookDto);
    Optional<CreateBookDto> update(Long id, CreateBookDto createBookDto);
}
