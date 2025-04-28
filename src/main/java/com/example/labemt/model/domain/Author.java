package com.example.labemt.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    @ManyToOne(cascade = CascadeType.MERGE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Country country;

    // Lifecycle callback for pre-update
    @PreUpdate
    public void onUpdate() {
        // You can add logic here to handle the update, e.g., change the country reference to null
        if (this.country != null) {
            // Ensure no violation happens if you update a country referenced by an author
            // You can add more complex logic to handle the update of the country reference
        }
    }

    @PreRemove
    public void onRemove() {
        // Handle cleanup if the author is removed due to country deletion
        if (this.country != null) {
            this.country = null; // or update logic
        }
    }

    public Author() {
    }

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
