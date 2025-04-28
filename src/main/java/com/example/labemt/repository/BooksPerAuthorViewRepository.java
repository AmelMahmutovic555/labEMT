package com.example.labemt.repository;

import com.example.labemt.model.views.BooksPerAuthorView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BooksPerAuthorViewRepository extends JpaRepository<BooksPerAuthorView, Long> {
//    BooksPerAuthorView findByAuthorId(Long authorId);
}

