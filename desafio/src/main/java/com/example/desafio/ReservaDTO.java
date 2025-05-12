package com.example.desafio;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public record ReservaDTO (
        Long id,
        @NotNull Long salaId,
        @NotBlank String responsavel,
        @NotNull @Future LocalDateTime iniciaDateTime,
        @NotNull @Future LocalDateTime finalizaDateTime
){}
