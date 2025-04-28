package com.example.labemt.service.domain.impl;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.domain.Country;
import com.example.labemt.model.projections.AuthorProjection;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.service.domain.AuthorService;
import com.example.labemt.service.domain.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryService countryService;
    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Author> listAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

//    @Override
//    public Optional<Author> save(Author author) {
//        Country country = new Country(author.getCountry().getName(), author.getCountry().getContinent());
//        countryService.save(country);
//        return Optional.of(authorRepository.save(new Author(author.getName(), author.getSurname(), country)));
//    }

    @Override
    public Optional<Author> save(Author author) {
//        Country country = countryService.findById(authorDto.getCountry())
//                .orElseThrow(() -> new RuntimeException("Country not found!"));
//
//        Author author = new Author(authorDto.getName(), authorDto.getSurname(), country);
        return Optional.of(authorRepository.save(author));
    }

    @Override
    public Optional<Author> edit(Long id, Author author) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        existingAuthor.setName(author.getName());
        existingAuthor.setSurname(author.getSurname());

        // Проверка ако country содржи само ID
        if (author.getCountry() != null && author.getCountry().getId() != null) {
            Country country = countryService.findById(author.getCountry().getId())
                    .orElseThrow(() -> new RuntimeException("Country not found"));
            existingAuthor.setCountry(country);
        }

        return Optional.of(authorRepository.save(existingAuthor));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorProjection> listAllByNameAndSurname() {
        return authorRepository.listAllAuthorsByNameAndSurname();
    }
}
