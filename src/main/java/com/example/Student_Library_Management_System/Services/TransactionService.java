package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.IssueBookDTO;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Models.Book;
import com.example.Student_Library_Management_System.Models.Card;
import com.example.Student_Library_Management_System.Models.Transactions;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;


    public String issueBook(IssueBookDTO issueBookDTO) throws Exception{

        int bookId = issueBookDTO.getBookId();
        int cardId = issueBookDTO.getCardId();
        // DTO work over


        Book book = bookRepository.findById(bookId).get();
        Card card  =cardRepository.findById(cardId).get();


        Transactions transactions = new Transactions();

        transactions.setBook(book);
        transactions.setCard(card);
        transactions.setIssueOperation(true);
        transactions.setTransactionStatus(TransactionStatus.PENDING);
        //transactions.setTransactionId();

        if(book==null || book.isIssued()==true){
            transactions.setTransactionStatus(TransactionStatus.FAIL);
            transactionRepository.save(transactions);
            throw new Exception("Book is not available");

        }
        if(card==null || (card.getCardStatus()!= CardStatus.ACTIVATED)){

            transactions.setTransactionStatus(TransactionStatus.FAIL);
            transactionRepository.save(transactions);
            throw  new Exception("Card is not valid");
        }

        transactions.setTransactionStatus(TransactionStatus.SUCCESS);


        //set attributes of book
        book.setIssued(true);
        //Btw the book and transaction : bidirectional

        List<Transactions> listOfTransactionForBook = book.getListOfTransactions();
        listOfTransactionForBook.add(transactions);
        book.setListOfTransactions(listOfTransactionForBook);


        //I need to make changes in the card
        //Book and the card
        List<Book> issuedBooksForCard = card.getBookIssued();
        issuedBooksForCard.add(book);
        card.setBookIssued(issuedBooksForCard);

        for(Book b: issuedBooksForCard){
            System.out.println(b.getName());
        }

        //Card and the Transaction : bidirectional (parent class)
        List<Transactions> transactionsListForCard = card.getTransactionList();
        transactionsListForCard.add(transactions);
        card.setTransactionList(transactionsListForCard);

        //save the parent.
        cardRepository.save(card);
        //automatically by cascading : book and transaction will be saved.
        //Saving the parent

        return "Book issued successfully";




    }

    public String getTransactions(int bookId,int cardId){

        List<Transactions> transactionsList = transactionRepository.getTransactionsForBookAndCard(bookId,cardId);

        String transactionId = transactionsList.get(0).getTransactionId();

        return transactionId;
    }

}