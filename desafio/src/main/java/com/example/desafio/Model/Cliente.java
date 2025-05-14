package com.example.desafio.Model;
import jakarta.persistence.*;

import lombok.*;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
     private String email;

}
