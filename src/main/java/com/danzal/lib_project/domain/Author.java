package com.danzal.lib_project.domain;

import com.danzal.lib_project.repositories.BookRepository;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection(targetClass = Long.class)
    private Set<Long> bookId = new HashSet<>();
    private String firstName;
    private String lastName;
    private String nationality;

    @ManyToMany
    @JoinTable(name = "author_books",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name= "book_id"))
    private Set<Book> books = new HashSet<>();



    public Author() {
    }

    public Author(String firstName, String lastName, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
    }

    public Author(String firstName, String lastName, Set<Book> authors, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.books = authors;
        this.nationality = nationality;    }


}
