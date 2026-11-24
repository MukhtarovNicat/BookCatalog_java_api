package com.example.bookcatalog.controller;

import com.example.bookcatalog.dto.BookRequest;
import com.example.bookcatalog.dto.BookResponse;
import com.example.bookcatalog.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookRequest request){
        BookResponse created = bookService.createBook(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getById(UUID id){
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(UUID id){
        bookService.deleteBook(id);
        return  ResponseEntity.noContent().build();
    }
}
