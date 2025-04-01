package com.example.labemt.service.application.impl;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.dto.CreateBookDto;
import com.example.labemt.service.application.BookApplicationService;
import com.example.labemt.service.domain.AuthorService;
import com.example.labemt.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public List<CreateBookDto> listAll() {
        return CreateBookDto.from(bookService.listAll());
    }

    @Override
    public Optional<CreateBookDto> create(CreateBookDto createBookDto) {
        Author author = authorService.findById(createBookDto.author()).orElse(null);
        return bookService.save(createBookDto.toBook(author)).map(CreateBookDto::from);
    }

    @Override
    public Optional<CreateBookDto> update(Long id, CreateBookDto createBookDto) {
        Author author = authorService.findById(createBookDto.author()).orElse(null);
        return bookService.edit(id, createBookDto.toBook(author)).map(CreateBookDto::from);
    }
}
