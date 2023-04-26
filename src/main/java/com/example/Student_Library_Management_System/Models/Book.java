package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.Genre;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int pages;


    private boolean issued;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;



    // Book is the child class if the author class ,so we are creating a Fk named author in table book;
    @ManyToOne
    @JoinColumn
    private Author author; //parent entity variable


    @ManyToOne
    @JoinColumn
    private Card card;


    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    private List<Transactions> listOfTransactions = new ArrayList<>();




    public Book() {
    }

    public List<Transactions> getListOfTransactions() {
        return listOfTransactions;
    }

    public void setListOfTransactions(List<Transactions> listOfTransactions) {
        this.listOfTransactions = listOfTransactions;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}