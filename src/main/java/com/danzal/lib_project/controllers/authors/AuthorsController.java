package com.danzal.lib_project.controllers.authors;

import com.danzal.lib_project.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorsController {

    private final AuthorService authorService;

    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors/authors")
    public String showAuthors(Model model){

        model.addAttribute("authors", authorService.getAuthors());

        return "/authors/authors";
    }
}
