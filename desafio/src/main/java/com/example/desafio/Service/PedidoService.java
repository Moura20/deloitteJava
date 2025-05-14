package com.example.desafio.Service;

import com.example.desafio.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {
    PedidoDTO criar(PedidoDTO dto);
    List<PedidoDTO> listar();
    void deletar(Long id);
    PedidoDTO atualizar(Long id, PedidoDTO dto);

}
