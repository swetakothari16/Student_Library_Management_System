package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Models.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
