package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity //
@Table(name = "card") // this is a table created in our database named LMS_rocks;
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @CreationTimestamp //auto time stamp  the time when an entry is created
    private Date createdOn;

    @UpdateTimestamp // set time when the entry is updated
    private Date updatedOn;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @OneToOne
    @JoinColumn
    Student studentVariableName;

    //this card is the parent for the book so configuration as follows
    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL )
    List<Book> bookIssued = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transactions> TransactionList = new ArrayList<>();

    public Card(){};


    public List<Book> getBookIssued() {
        return bookIssued;
    }

    public void setBookIssued(List<Book> bookIssued) {
        this.bookIssued = bookIssued;
    }

    public List<Transactions> getTransactionList() {
        return TransactionList;
    }

    public void setTransactionList(List<Transactions> transactionList) {
        TransactionList = transactionList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Student getStudent() {
        return studentVariableName;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public void setStudent(Student student) {
        this.studentVariableName = student;
    }
}