package com.example.bookcatalog.dto.AuthorDtos;

import jakarta.validation.constraints.NotBlank;

public record AuthorRequest
        (
            @NotBlank(message = "Ad Bos ola bilmez")
            String fullName
        )
{ }
