package com.example.labemt.model.dto;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.domain.Book;
import com.example.labemt.model.domain.Category;

import java.util.List;
import java.util.stream.Collectors;

public record CreateBookDto(String name, Category category, Long author, Integer availableCopies) {
    public static CreateBookDto from(Book book) {
        return new CreateBookDto(book.getName(), book.getCategory(), book.getAuthor().getId(), book.getAvailableCopies());
    }

    public static List<CreateBookDto> from(List<Book> books) {
        return books.stream().map(CreateBookDto::from).collect(Collectors.toList());
    }

    public Book toBook(Author author){
        return new Book(name, category, author, availableCopies);
    }
}
