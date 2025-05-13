package com.example.desafio.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaDTO(
    long id,
    @NotBlank String nome,
    @NotNull Integer capacidade,
    @NotBlank String localizacao
    ){}



