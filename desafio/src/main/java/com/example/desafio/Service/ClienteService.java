package com.example.desafio.Service;



import com.example.desafio.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    ClienteDTO criar(ClienteDTO dto);

    List<ClienteDTO> listar();

    ClienteDTO buscarPorId(Long id);

    ClienteDTO atualizar(Long id, ClienteDTO dto);

    void deletar(Long id);
}

