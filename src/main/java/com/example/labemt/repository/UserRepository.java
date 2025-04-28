package com.example.labemt.repository;

import com.example.labemt.model.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @EntityGraph(
            attributePaths = {"username", "password", "name", "surname"}
    )
    @Query("select u from User u")
    List<User> loadAll();

}
