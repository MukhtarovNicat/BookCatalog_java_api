package com.example.bookcatalog.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record BookRequest
        (
                @NotBlank(message = "Kitabin adi bos ola bilmez")
                String title,

                @Positive(message = "Sehife sayi 0 dan boyuk olmalidir")
                Integer pageCount,

                @Size(max = 1000, message = "Maksimum 1000 simvol ola biler")
                String description
        )
{ }
