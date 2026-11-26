package com.example.bookcatalog.dto.AuthorDtos;

import java.util.UUID;

public record AuthorResponse
        (
                UUID id,
                String fullName
        )
{ }
