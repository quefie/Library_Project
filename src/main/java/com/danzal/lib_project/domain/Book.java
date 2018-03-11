package com.danzal.lib_project.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String title;
     private int year;
     private String city;
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


     public Book(String title, int year, String city, String publisher, String description, Set<Author> authors, Librarian librarian, Set<Category> categories) {
          this.title = title;
          this.year = year;
          this.city = city;
          this.publisher = publisher;
          this.description = description;
          this.authors = authors;
          this.librarian = librarian;
          this.categories = categories;
     }


}
