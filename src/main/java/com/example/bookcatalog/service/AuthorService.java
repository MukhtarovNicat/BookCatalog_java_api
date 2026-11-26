package com.example.bookcatalog.service;

import com.example.bookcatalog.dto.AuthorDtos.AuthorRequest;
import com.example.bookcatalog.dto.AuthorDtos.AuthorResponse;
import com.example.bookcatalog.entity.Author;
import com.example.bookcatalog.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Transactional
    public AuthorResponse createAuthor(AuthorRequest request)
    {
        Author author = new Author();
        author.setFullName(request.fullName());

        Author savedAuthor = authorRepository.save(author);
        return  mapToResponse(savedAuthor);
    }

    public List<AuthorResponse> getAllAuthors()
    {
        return authorRepository.findAll()
                .stream()
                .map(author -> new AuthorResponse(
                        author.getId(),
                        author.getFullName()
                )).toList();
    }

    public AuthorResponse mapToResponse(Author author)
    {
        return new AuthorResponse(
                author.getId(),
                author.getFullName()
        );
    }
}
