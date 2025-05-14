package com.example.desafio.Controller;


import com.example.desafio.Model.Pedido;
import com.example.desafio.Repository.PedidoRepository;
import com.example.desafio.Service.PedidoService;
import com.example.desafio.dto.PedidoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor

public class PedidoController {

    private final PedidoRepository pedidoRepository;
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> criar(@RequestBody PedidoDTO dto) {
        return
        ResponseEntity.status(201).body(pedidoService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listar() {
        return
        ResponseEntity.ok(pedidoService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizar(@PathVariable Long id, @RequestBody PedidoDTO dto) {
        PedidoDTO atualizado = pedidoService.atualizar(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

 }

