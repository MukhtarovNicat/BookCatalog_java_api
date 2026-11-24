package com.example.bookcatalog.service;

import com.example.bookcatalog.dto.BookRequest;
import com.example.bookcatalog.dto.BookResponse;
import com.example.bookcatalog.entity.Book;
import com.example.bookcatalog.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public BookResponse createBook(BookRequest request){
        Book book = new Book();
        book.setTitle(request.title());
        book.setDescription(request.description());
        book.setPageCount(request.pageCount());

        Book savedBook = bookRepository.save(book);
        return mapToResponse(savedBook);
    }

    public List<BookResponse> getAllBooks(){
        return bookRepository.findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    public BookResponse getBookById(UUID id){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitab tapilmadi: " + id));
        return mapToResponse(book);
    }

    @Transactional
    public void deleteBook(UUID id){
        if(!bookRepository.existsById(id)){
            throw new RuntimeException(("Siliecek kitab tapilmadi: " + id));
        }
        bookRepository.deleteById(id);
    }

    private BookResponse mapToResponse(Book book){
        return new BookResponse(
          book.getId(),
          book.getTitle(),
          book.getPageCount(),
          book.getDescription()
        );
    }
}
