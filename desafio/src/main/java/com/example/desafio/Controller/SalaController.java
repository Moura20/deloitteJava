package com.example.desafio.Controller;

import com.example.desafio.dto.SalaDTO;
import com.example.desafio.Service.SalaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
@RequiredArgsConstructor

public class SalaController {

    private final SalaService salaService;

    @PostMapping
    public ResponseEntity<SalaDTO> criarSala(@RequestBody SalaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(salaService.createSala(dto));
    }

    @GetMapping
    public List<SalaDTO> listarSalas() {
        return salaService.getAllSalas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(salaService.getSalaById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaDTO> updateSala(@PathVariable Long id, @RequestBody SalaDTO salaDTO) {
        return ResponseEntity.ok(salaService.updateSala(id, salaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSala(@PathVariable Long id) {
        salaService.deleteSala(id);
        return ResponseEntity.noContent().build();
    }
}

