package com.example.Student_Library_Management_System.Models;


import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;


@Entity
@Table(name="Transactions")
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatus TransactionStatus;

    private int fine;

    @Column(unique = true)
    private String transactionId = UUID.randomUUID().toString();

    @CreationTimestamp
    private Date TransactionDate;

    private boolean IssueOperation;

    @ManyToOne
    @JoinColumn
    private Book book;

    @ManyToOne
    @JoinColumn
    private Card card;

    public Transactions(){}

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public com.example.Student_Library_Management_System.Enums.TransactionStatus getTransactionStatus() {
        return TransactionStatus;
    }

    public void setTransactionStatus(com.example.Student_Library_Management_System.Enums.TransactionStatus transactionStatus) {
        TransactionStatus = transactionStatus;
    }
    //public void setTransactionStatus(String transactionStatus) {
    // TransactionStatus = transactionStatus;
    // }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Date getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        TransactionDate = transactionDate;
    }

    public boolean isIssueOperation() {
        return IssueOperation;
    }

    public void setIssueOperation(boolean issueOperation) {
        IssueOperation = issueOperation;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}