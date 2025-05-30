package com.example.labemt.service.domain.impl;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.domain.Book;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.BookRepository;
import com.example.labemt.service.domain.AuthorService;
import com.example.labemt.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final AuthorRepository authorRepository;
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.of(bookRepository.findById(id)).orElse(null);
    }

    @Override
    public Optional<Book> save(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            if (book.getName() != null) {
                existingBook.setName(book.getName());
            }
            if (book.getCategory() != null) {
                existingBook.setCategory(book.getCategory());
            }
            if (book.getAuthor() != null && book.getAuthor().getId() != null) {
                // Ensure the author's ID is not null before saving
                Author author = authorService.findById(book.getAuthor().getId()).orElse(null);
                if (author != null) {
                    existingBook.setAuthor(author);
                }
            }
            if (book.getAvailableCopies() != null) {
                existingBook.setAvailableCopies(book.getAvailableCopies());
            }
            return bookRepository.save(existingBook);
        });
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

}
