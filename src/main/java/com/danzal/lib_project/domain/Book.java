package com.danzal.lib_project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(exclude = {"authors"})
@Entity
public class Book {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "ID")
     private Long id;
     private String title;
     private String format;
     private String language;
     private int pubYear;
     private String publisher;

     @Lob
     private String description;

     @ManyToMany(mappedBy = "books")
     private Set<Author> authors = new HashSet<>();

     @ManyToOne
     private Librarian librarian;

     @ManyToMany
     @JoinTable(name = "category_book",
             joinColumns = @JoinColumn(name = "book_id"),
             inverseJoinColumns = @JoinColumn(name= "category_id"))
     private Set<Category> categories = new HashSet<>();

          public Book() {
          }

     public Book(String title, String format, String language, int pubYear, String publisher, Set<Author> authors) {
          this.title = title;
          this.format = format;
          this.language = language;
          this.pubYear = pubYear;
          this.publisher = publisher;
          this.authors = authors;
     }

     public Book(String title, String format, String language, int pubYear, String publisher) {
               this.title = title;
               this.format = format;
               this.language = language;
               this.pubYear = pubYear;
               this.publisher = publisher;

          }

          public Book(String title, String format, String language, int pubYear, String publisher, String description, Set<Author> authors, Librarian librarian, Set<Category> categories) {
               this.title = title;
               this.format = format;
               this.language = language;
               this.pubYear = pubYear;
               this.publisher = publisher;
               this.description = description;
               this.authors = authors;
               this.librarian = librarian;
               this.categories = categories;
          }

}
