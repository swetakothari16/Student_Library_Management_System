package com.example.Student_Library_Management_System.Services;


import com.example.Student_Library_Management_System.DTOs.addAuthorDTO;
import com.example.Student_Library_Management_System.Models.Author;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    AuthorRepository authorRepository;
    public String createAuthor(addAuthorDTO addAuthorDTO){

        Author author = new Author();

        author.setName(addAuthorDTO.getName());
        author.setAge(addAuthorDTO.getAge());
        author.setCountry(addAuthorDTO.getCountry());
        author.setRating(addAuthorDTO.getRating());

        authorRepository.save(author);
        return "Author added successfully";


    }
    public String DeleteAuthor(int id){
        authorRepository.deleteById(id);
        return "Author deleted succesfully";
    }

}