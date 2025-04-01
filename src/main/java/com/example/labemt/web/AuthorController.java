package com.example.labemt.web;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.dto.CreateAuthorDto;
import com.example.labemt.service.application.AuthorApplicationService;
import com.example.labemt.service.domain.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final AuthorApplicationService authorApplicationService;

    public AuthorController(AuthorService authorService, AuthorApplicationService authorApplicationService) {
        this.authorService = authorService;
        this.authorApplicationService = authorApplicationService;
    }

    @Operation(summary = "Get a list of all authors", description = "Retrieves all authors from the system")
    @GetMapping
    public List<CreateAuthorDto> findAll() {
        return authorApplicationService.listAll();
    }

    @Operation(summary = "Find an author by ID", description = "Retrieves an author by their unique identifier")
    @GetMapping("/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id) {
        return authorService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new author", description = "Creates a new author and returns the created author data")
    @PostMapping("/add")
    public ResponseEntity<CreateAuthorDto> save(@RequestBody CreateAuthorDto author) {
        return authorApplicationService.create(author)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update an existing author", description = "Updates an author with the given ID and new data")
    @PutMapping("/edit/{id}")
    public ResponseEntity<CreateAuthorDto> update(@PathVariable Long id, @RequestBody CreateAuthorDto author) {
        return authorApplicationService.update(id, author)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete an author by ID", description = "Deletes the author with the given ID from the system")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (authorService.findById(id).isPresent()) {
            authorService.delete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
