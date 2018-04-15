package com.danzal.lib_project.controllers.authors;

import com.danzal.lib_project.commands.AuthorCommand;
import com.danzal.lib_project.services.Author.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class AuthorsController {

    private final AuthorService authorService;


    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping({"/authors/home", "/authors/home"})
    public String showAuthors(Model model){

        model.addAttribute("authors", authorService.getAuthors());

        return "/authors/home";
    }

    @GetMapping("/authors/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("author", authorService.findById(new Long(id)));

        model.addAttribute("books", authorService.getBooks());
        return "authors/show";
    }


    @GetMapping("/authors/new")
    public String newAuthor( Model model){
        model.addAttribute("author", new AuthorCommand());
        model.addAttribute("books", authorService.getBooks());

        return "authors/authorform";
    }


    @GetMapping("authors/{id}/update")
    public String updateAuthor(@PathVariable String id, Model model){
        model.addAttribute("author", authorService.findCommandById(Long.valueOf(id)));
        model.addAttribute("books", authorService.getBooks());
        return "authors/authorform";

    }

    @PostMapping("authors")
    public String saveOrUpdate(@ModelAttribute AuthorCommand command){

        AuthorCommand savedCommand = authorService.saveAuthorCommand(command);
        return "redirect:/authors/home";
    }

    @GetMapping("authors/{id}/delete")
    public String deleteById(@PathVariable String id){
        log.debug("Deleting id: " + id);

        authorService.deleteById(Long.valueOf(id));

        return "redirect:/authors/home";
    }

}
