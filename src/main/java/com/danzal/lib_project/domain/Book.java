package com.danzal.lib_project.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

     @ManyToMany
     @JoinTable(name = "authors_of_books",
          joinColumns = @JoinColumn(name = "book_id"),
          inverseJoinColumns = @JoinColumn(name= "author_id"))
     private Set<Author> authors = new HashSet<>();

     @ManyToOne
     private Librarian librarian;

     @ManyToMany
     @JoinTable(name = "categories_of_book",
             joinColumns = @JoinColumn(name = "book_id"),
             inverseJoinColumns = @JoinColumn(name= "category_id"))
     private Set<Category> categories = new HashSet<>();


}
