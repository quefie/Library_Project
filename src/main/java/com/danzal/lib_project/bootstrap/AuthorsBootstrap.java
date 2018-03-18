package com.danzal.lib_project.bootstrap;


import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.domain.Book;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class AuthorsBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorsBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        bookRepository.saveAll(getBooks());
        authorRepository.saveAll(getAuthors());


    }

    private List<Author> getAuthors(){
        List<Author> authors = new ArrayList<>();



       // Set<Book> books3 = new HashSet<>();
       // books1.add();

        Author author1 = new Author("First 1#", "Last 1#", "Poland #1");
        Author author2 = new Author("First 2#", "Last 2#", "Poland #2");
        Author author3 = new Author("First 3#", "Last 3#", "Poland #3");



        authors.add(author1);
        authors.add(author2);
        authors.add(author3);


        return authors;

    }

    private List<Book> getBooks(){
        List<Book> books = new ArrayList<>();
       /* Author author1 = new Author("First 1#", "Last 1#", "Poland #1");
        Author author2 = new Author("First 2#", "Last 2#", "Poland #2");
        Author author3 = new Author("First 3#", "Last 3#", "Poland #3");
*/




      /*  Set<Author> authors2 = new HashSet<>();
        authors2.add(getAuthors().get(2));
        authors2.add(getAuthors().get(3));

        Set<Author> authors3 = new HashSet<>();
        authors3.add(getAuthors().get(3));
*/
        Book book1 = new Book("Test book #1", "Hard", "English", 2018, "danzal 1#");
        Book book2 = new Book("Test book #2", "Hard", "English", 2018, "danzal 2#");
        Book book3 = new Book("Test book #3", "Hard", "English", 2018, "danzal 3#");



        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }



            }
