package com.example.desafio.dto;

import java.math.BigDecimal;

public record PedidoDTO(Long id, String descricao, BigDecimal valor, int quantidade) {


}
