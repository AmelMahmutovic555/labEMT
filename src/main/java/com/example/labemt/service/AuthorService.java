package com.example.labemt.service;


import com.example.labemt.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(Author book);
    Optional<Author> edit(Long id, Author author);
    void delete(Long id);
}
