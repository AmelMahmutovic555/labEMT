package com.example.labemt.config;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.domain.Book;
import com.example.labemt.model.domain.User;
import com.example.labemt.model.enumerations.Category;
import com.example.labemt.model.domain.Country;
import com.example.labemt.model.enumerations.Role;
import com.example.labemt.repository.AuthorRepository;
import com.example.labemt.repository.BookRepository;
import com.example.labemt.repository.CountryRepository;
import com.example.labemt.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init(){
//        Country country = new Country("Macedonia", "Europe");
//        country = countryRepository.save(country);
//
//        // Потоа се зачувува авторот со претходно зачуваната држава
//        Author author = new Author("Amel", "Mahmutovic", country);
//        author = authorRepository.save(author);

        User user = new User("amel555", passwordEncoder.encode("amel"), "Amel", "Mahmutovic", Role.ROLE_ADMIN);
        User user1 = new User("amel123", passwordEncoder.encode("amel"), "Amel", "Mahmutovic", Role.ROLE_USER);

        userRepository.save(user);
        userRepository.save(user1);
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
