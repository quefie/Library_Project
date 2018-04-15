package com.danzal.lib_project.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AuthorTest {

    Author author;

    @Before
    public void setUp(){
        author = new Author();
    }

    @Test
    public void getNames() {

        author.setFirstName("Adam");
        author.setLastName("Zaleski");

        assertEquals("Adam Zaleski", author.getNames());
    }

    @Test
    public void getId() {
        Long idValue = 4l;

        author.setId(idValue);

        assertEquals(idValue, author.getId());
    }

    @Test
    public void getBooks() {

        Set<Book> books = new HashSet<>();
        Book bookTest = new Book();
        bookTest.setTitle("Test Title");
        books.add(bookTest);

        author.setBooks(books);

        assertEquals(bookTest.getTitle(), author.getBooks().iterator().next().getTitle());

    }
}