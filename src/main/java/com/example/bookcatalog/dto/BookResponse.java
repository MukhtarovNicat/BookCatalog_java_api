package com.example.bookcatalog.dto;

import java.util.UUID;

public record BookResponse
        (
            UUID id,
            String title,
            Integer pageCount,
            String description
        )
{ }
