package com.example.desafio;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Root;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String responsavel;
    private LocalDateTime inicia;
    private LocalDateTime finaliza;

    @ManyToOne
    @JoinColumn(name = "room_id",nullable = false)
    private Sala sala;


}
