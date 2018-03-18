package com.danzal.lib_project.controllers.books;

import com.danzal.lib_project.domain.Book;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BooksController {

    private final BookService bookService;
    private final AuthorRepository authorRepository;

    public BooksController(BookService bookService, AuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/books/home")
    public String showBooks(Model model, Book book){

        model.addAttribute("books", bookService.getBooks());

        model.addAttribute("authors", bookService.getBookAuthors().equals(book));
        return "books/home";
    }
}
