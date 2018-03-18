package com.danzal.lib_project.controllers.authors;

import com.danzal.lib_project.commands.AuthorCommand;
import com.danzal.lib_project.repositories.AuthorRepository;
import com.danzal.lib_project.services.AuthorService;
import com.danzal.lib_project.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class AuthorsController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorsController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @RequestMapping("/authors/home")
    public String showAuthors(Model model){

        model.addAttribute("authors", authorService.getAuthors());

        return "/authors/home";
    }

    @GetMapping("/authors/new")
    public String newAuthor( Model model){
        model.addAttribute("author", new AuthorCommand());
        model.addAttribute("books", bookService.getBooks());

        return "authors/authorform";
    }


    @GetMapping("author/{id}/update")
    public String updateAuthor(@PathVariable String id, Model model){
        model.addAttribute("author", authorService.findCommandById(Long.valueOf(id)));

        return "author/authorform";

    }

    @PostMapping("author")
    public String saveOrUpdate(@ModelAttribute AuthorCommand command){

        AuthorCommand savedCommand = authorService.saveAuthorCommand(command);
        return "redirect:/author/" + savedCommand.getId() + "/show";
    }

    @GetMapping("author/{id}/delete")
    public String deleteById(@PathVariable String id){
        log.debug("Deleting id: " + id);

        authorService.deleteById(Long.valueOf(id));

        return "redirect:/authors/show";
    }

}
