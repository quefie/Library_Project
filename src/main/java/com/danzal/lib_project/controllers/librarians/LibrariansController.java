package com.danzal.lib_project.controllers.librarians;

import com.danzal.lib_project.commands.LibrarianCommand;
import com.danzal.lib_project.services.Librarian.LibrarianService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LibrariansController {

    private final LibrarianService librarianService;

    public LibrariansController(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @GetMapping({"/librarians/home", "librarians/home"})
    public String showLibrarians(Model model){
        model.addAttribute("librarians", librarianService.getLibrarians());
        model.addAttribute("books", librarianService.getBooks());

        return "/librarians/home";
    }

    @GetMapping({"/librarians/{id}/show", "/librarians/{id}/show/"})
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("librarian", librarianService.findById(new Long(id)));
        model.addAttribute("books", librarianService.getBooks());

        return "/librarians/show";
    }

    @GetMapping({"/librarians/new", "/librarians/new/"})
    public String newLibrarian(Model model){
        model.addAttribute("librarian", new LibrarianCommand());
        model.addAttribute("books", librarianService.getBooks());

        return "/librarians/librarianform";
    }

    @PostMapping("librarians")
    public String saveOrUpdate(@ModelAttribute LibrarianCommand command){
        LibrarianCommand librarianCommand = librarianService.saveLibrrarianCommand(command);

        return "redirect:/librarians/home";
    }

    @GetMapping({"/librarians/{id}/delete", "/librarians/{id}/detele/"})
    public String deleteById(@PathVariable String id){
        librarianService.deleteById(Long.valueOf(id));

        return "redirect:/librarians/home";
    }
}
