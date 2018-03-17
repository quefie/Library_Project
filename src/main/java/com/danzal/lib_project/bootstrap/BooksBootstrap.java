package com.danzal.lib_project.bootstrap;

import com.danzal.lib_project.domain.Author;
import com.danzal.lib_project.domain.Book;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BooksBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BooksBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        bookRepository.saveAll(getBooks());
    }

    private List<Book> getBooks(){
        List<Book> books = new ArrayList<>();

        Author author1 = new Author("First 1#", "Last 1#", "Poland #1");
        Author author2 = new Author("First 2#", "Last 2#", "Poland #2");
        Author author3 = new Author("First 3#", "Last 3#", "Poland #3");

        Set<Author> authors1 = new HashSet<>();
        authors1.add(author1);
        authors1.add(author2);

        Set<Author> authors2 = new HashSet<>();
        authors2.add(author2);
        authors2.add(author3);

        Set<Author> authors3 = new HashSet<>();
        authors3.add(author3);

        Book book1 = new Book("Test book #1", "Hard", "English", 2018, "danzal 1#",authors1);
        Book book2 = new Book("Test book #2", "Hard", "English", 2018, "danzal 2#",authors2);
        Book book3 = new Book("Test book #3", "Hard", "English", 2018, "danzal 3#",authors3);

        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }
}
