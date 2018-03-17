package com.danzal.lib_project.controllers.books;

import com.danzal.lib_project.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books/home")
    public String showBooks(Model model){

        model.addAttribute("books", bookService.getBooks());

        return "books/home";
    }
}
