package com.example.desafio.Model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;
    private String descricao;
    private int quantidade;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
