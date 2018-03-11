package com.danzal.lib_project.controllers;


import com.danzal.lib_project.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private final AuthorService authorService;

    public IndexController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){

        model.addAttribute("authors", authorService.getAuthors());
        return "index";
    }
}
