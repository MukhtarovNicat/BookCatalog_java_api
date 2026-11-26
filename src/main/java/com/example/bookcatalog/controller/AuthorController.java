package com.example.bookcatalog.controller;

import com.example.bookcatalog.dto.AuthorDtos.AuthorRequest;
import com.example.bookcatalog.dto.AuthorDtos.AuthorResponse;
import com.example.bookcatalog.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponse> createAuthor(@Valid @RequestBody AuthorRequest request){
        AuthorResponse response = authorService.createAuthor(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponse>> getAllAuthors(){return ResponseEntity.ok(authorService.getAllAuthors());}
}
