package com.example.labemt.service.application;

import com.example.labemt.model.dto.CreateAuthorDto;
import com.example.labemt.model.dto.CreateBookDto;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<CreateAuthorDto> listAll();
    Optional<CreateAuthorDto> create(CreateAuthorDto createAuthorDto);
    Optional<CreateAuthorDto> update(Long id, CreateAuthorDto createAuthorDto);
}
