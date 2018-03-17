package com.danzal.lib_project.domain;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Book {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String title;
     private String format;
     private String language;
     private int pubYear;
     private String publisher;

     @Lob
     private String description;

     @ManyToMany(mappedBy = "authors")
     private Set<Author> authors;

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
/*
     public String getAuthorsN() {

          String[] namesArray = authors.toArray(new String[authors.size()]);
          String names = Arrays.toString(namesArray);

          String contactString = authors.stream().map(Author::getNames).collect(Collectors.joining(","));

          System.out.println(authors);
          System.out.println(names);
          System.out.println("\n" + contactString);
          return names;
     }
*/
     public Set<Author> getAuthors() {
          return authors;
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getTitle() {
          return title;
     }

     public void setTitle(String title) {
          this.title = title;
     }

     public String getFormat() {
          return format;
     }

     public void setFormat(String format) {
          this.format = format;
     }

     public String getLanguage() {
          return language;
     }

     public void setLanguage(String language) {
          this.language = language;
     }

     public int getPubYear() {
          return pubYear;
     }

     public void setPubYear(int pubYear) {
          this.pubYear = pubYear;
     }

     public String getPublisher() {
          return publisher;
     }

     public void setPublisher(String publisher) {
          this.publisher = publisher;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public void setAuthors(Set<Author> authors) {
          this.authors = authors;
     }

     public Librarian getLibrarian() {
          return librarian;
     }

     public void setLibrarian(Librarian librarian) {
          this.librarian = librarian;
     }

     public Set<Category> getCategories() {
          return categories;
     }

     public void setCategories(Set<Category> categories) {
          this.categories = categories;
     }
}
