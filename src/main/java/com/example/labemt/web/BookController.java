package com.example.labemt.web;

import com.example.labemt.model.domain.Book;
import com.example.labemt.model.dto.CreateBookDto;
import com.example.labemt.service.application.BookApplicationService;
import com.example.labemt.service.domain.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final BookApplicationService bookApplicationService;

    public BookController(BookService bookService, BookApplicationService bookApplicationService) {
        this.bookService = bookService;
        this.bookApplicationService = bookApplicationService;
    }

    @Operation(summary = "Get a list of all books", description = "Retrieves all books from the system")
    @GetMapping
    public List<CreateBookDto> findAll() {
        return bookApplicationService.listAll();
    }

    @Operation(summary = "Find a book by ID", description = "Retrieves a book by its unique identifier")
    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return bookService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new book", description = "Creates a new book and returns the created book data")
    @PostMapping("/add")
    public ResponseEntity<CreateBookDto> save1(@RequestBody CreateBookDto createBookDto) {
        return bookApplicationService.create(createBookDto).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Save a book", description = "Saves a book entity and returns the saved book")
    @PostMapping("/save")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return bookService.save(book)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an existing book", description = "Updates a book with the given ID and new data")
    @PutMapping("/edit/{id}")
    public ResponseEntity<CreateBookDto> update(@PathVariable Long id, @RequestBody CreateBookDto createBookDto) {
        return bookApplicationService.update(id, createBookDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a book by ID", description = "Deletes the book with the given ID from the system")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookService.findById(id).isPresent()) {
            bookService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
