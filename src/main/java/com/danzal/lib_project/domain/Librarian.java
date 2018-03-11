package com.danzal.lib_project.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Librarian {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstName;
    private String lastName;
    private int librarianNumber;
    private String adress;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "librarian")
    private Set<Book> loanBooks = new HashSet<>();


    public Librarian(String firstName, String lastName, int librarianNumber, String adress, Set<Book> loanBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.librarianNumber = librarianNumber;
        this.adress = adress;
        this.loanBooks = loanBooks;
    }
}
