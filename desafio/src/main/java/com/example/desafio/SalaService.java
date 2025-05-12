package com.example.desafio;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import  jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;






@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;

    public SalaDTO createSala(SalaDTO salaDTO) {
        if (salaRepository.findByNome(salaDTO.nome()).isPresent()) {
            throw new IllegalArgumentException("Já existe uma sala com esse nome");
        }

        Sala sala = Sala.builder()
                .nome(salaDTO.nome())
                .capacidade(salaDTO.capacidade())
                .localizacao(salaDTO.localizacao())
                .build();

        return toDTO(salaRepository.save(sala));
    }

    public List<SalaDTO> getAllSalas() {
        return salaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public SalaDTO getSalaById(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));
        return toDTO(sala);
    }

    public SalaDTO updateSala(Long id, SalaDTO salaDTO) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));

        sala.setNome(salaDTO.nome());
        sala.setCapacidade(salaDTO.capacidade());
        sala.setLocalizacao(salaDTO.localizacao());

        return toDTO(salaRepository.save(sala));
    }

    public void deleteSala(Long id) {
        Sala sala = salaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));
        salaRepository.delete(sala);
    }

    private SalaDTO toDTO(Sala sala) {
        return new SalaDTO(
                sala.getId(),
                sala.getNome(),
                sala.getCapacidade(),
                sala.getLocalizacao()
        );
    }
}