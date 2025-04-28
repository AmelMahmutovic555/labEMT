package com.example.labemt.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@Data
@Entity
@Subselect("SELECT * FROM public.authors_per_country")
@Immutable
public class AuthorsPerCountryView {
    @Id
    @Column(name = "country_id")
    private Long id;

    @Column(name = "num_authors")
    private Integer numAuthors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumAuthors() {
        return numAuthors;
    }

    public void setNumAuthors(Integer numAuthors) {
        this.numAuthors = numAuthors;
    }
}
