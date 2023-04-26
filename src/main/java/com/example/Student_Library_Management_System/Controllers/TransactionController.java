package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.DTOs.IssueBookDTO;
import com.example.Student_Library_Management_System.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("issueBook")
    public String issueRequest (@RequestBody IssueBookDTO issueBookDTO){

        try{
            return transactionService.issueBook(issueBookDTO);
        }catch(Exception e){
            return e.getMessage();
        }
    }

    @GetMapping("/getTxnInfo")
    public String getTransactionEntry(@RequestParam("bookId")Integer bookId,@RequestParam
            ("cardId")Integer cardId){

        return transactionService.getTransactions(bookId,cardId);
    }


}