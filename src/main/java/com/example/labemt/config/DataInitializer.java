package com.example.labemt.config;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.domain.Book;
import com.example.labemt.model.domain.Category;
import com.example.labemt.model.domain.Country;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.BookRepository;
import com.example.labemt.repository.CountryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init(){
//        Country country = new Country("Macedonia", "Europe");
//        country = countryRepository.save(country);
//
//        // Потоа се зачувува авторот со претходно зачуваната држава
//        Author author = new Author("Amel", "Mahmutovic", country);
//        author = authorRepository.save(author);

        // На крај се зачувува книгата со претходно зачуваниот автор
        for (int i=1; i<11; i++){
            Country country = new Country("Macedonia", "Europe");
            country = countryRepository.save(country);

            // Потоа се зачувува авторот со претходно зачуваната држава
            Author author = new Author("Amel " + i, "Mahmutovic " + i, country);
            author = authorRepository.save(author);
            Book book = new Book("Book " + i, Category.BIOGRAPHY, author, 15-i);
            bookRepository.save(book);
        }
    }
}
