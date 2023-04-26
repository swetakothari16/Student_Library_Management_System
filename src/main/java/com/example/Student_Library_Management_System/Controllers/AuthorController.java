package com.example.Student_Library_Management_System.Controllers;


import com.example.Student_Library_Management_System.DTOs.addAuthorDTO;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Services.AuthorService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {


    @Autowired
    AuthorService authorService;


    @PostMapping("/add")
    public String addAuthor(@RequestBody addAuthorDTO addAuthorDTO){


        return authorService.createAuthor(addAuthorDTO);
    }

    @DeleteMapping("/delete")
    public String deleteAuthor(@RequestParam("id") int id){

        return authorService.DeleteAuthor(id);
    }

}
