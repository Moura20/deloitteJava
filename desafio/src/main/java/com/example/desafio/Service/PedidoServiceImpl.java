package com.example.desafio.Service;

import com.example.desafio.dto.PedidoDTO;
import com.example.desafio.Model.Pedido;
import com.example.desafio.Repository.PedidoRepository;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository repository;

    @Override
    public PedidoDTO criar(PedidoDTO dto) {

        if (dto.valor().compareTo(BigDecimal.valueOf(10.00)) < 0) {
            throw new IllegalArgumentException("Valor mínimo para pedido é R$ 10,00");
        }

        Pedido pedido = Pedido.builder()
                .descricao(dto.descricao())
                .valor(dto.valor())
                .quantidade(dto.quantidade())
                .build();

        return toDTO(repository.save(pedido));
    }

    @Override
    public List<PedidoDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private PedidoDTO toDTO(Pedido pedido) {
        return new PedidoDTO(
                pedido.getId(),
                pedido.getDescricao(),
                pedido.getValor(),
                pedido.getQuantidade()
        );
    }
}
