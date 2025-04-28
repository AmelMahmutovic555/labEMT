package com.example.labemt.repository;

import com.example.labemt.model.domain.Author;
import com.example.labemt.model.projections.AuthorProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("select a.name as name, a.surname as surname from Author a")
    List<AuthorProjection> listAllAuthorsByNameAndSurname();
}
