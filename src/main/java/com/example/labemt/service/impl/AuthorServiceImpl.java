package com.example.labemt.service.impl;

import com.example.labemt.model.Author;
import com.example.labemt.model.Country;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.service.AuthorService;
import com.example.labemt.service.CountryService;
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

    @Override
    public Optional<Author> save(Author book) {
        return Optional.of(authorRepository.save(book));
    }

    @Override
    public Optional<Author> edit(Long id, Author author) {
        authorRepository.findById(id).map(existingAuthor -> {
            if (author.getName()!=null){
                existingAuthor.setName(author.getName());
            }
            if (author.getSurname()!=null){
                existingAuthor.setSurname(author.getSurname());
            }
            if (author.getCountry()!=null){
//                countryService.findById(author.getCountry().getId()).ifPresent(existingAuthor::setCountry);
                Country country = countryService.findById(author.getCountry().getId()).orElse(null);
                countryService.save(country);
                author.setCountry(country);
            }
            return authorRepository.save(existingAuthor);
        });
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
