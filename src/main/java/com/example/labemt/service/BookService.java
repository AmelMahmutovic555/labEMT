package com.example.labemt.service;

import com.example.labemt.model.Book;
import com.example.labemt.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listAll();
    Optional<Book> findById(Long id);
    Optional<Book> save(Book book);
    Optional<Book> edit(Long id, Book book);
    void delete(Long id);
}
