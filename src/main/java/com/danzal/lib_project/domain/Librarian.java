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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "loan_books")
    private Set<Book> loanBooks = new HashSet<>();



}
