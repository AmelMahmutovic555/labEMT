package com.example.labemt.jobs;

import com.example.labemt.repository.BooksPerAuthorViewRepository;
import com.example.labemt.service.domain.BookService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    private final BookService bookService;
    private final BooksPerAuthorViewRepository booksPerAuthorViewRepository;

    public ScheduledTasks(BookService bookService, BooksPerAuthorViewRepository booksPerAuthorViewRepository) {
        this.bookService = bookService;
        this.booksPerAuthorViewRepository = booksPerAuthorViewRepository;
    }

    @Scheduled(cron = "* * * * * *")
    public void refreshMaterializedView(){
        System.out.printf("There are %d books per author", booksPerAuthorViewRepository.count());
    }
}
