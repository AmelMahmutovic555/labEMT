package com.example.labemt.service.domain;


import com.example.labemt.model.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAll();
    Optional<Author> findById(Long id);
    Optional<Author> save(Author author);
//    Optional<Author> save(Author author);
    Optional<Author> edit(Long id, Author author);
    void delete(Long id);
}
