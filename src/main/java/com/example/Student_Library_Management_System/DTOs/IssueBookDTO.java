package com.example.Student_Library_Management_System.DTOs;

public class IssueBookDTO {

    private int cardId;
    private int bookId;

    public IssueBookDTO() {
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}