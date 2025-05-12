package com.example.desafio;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final SalaRepository salaRepository;

    public ReservaDTO criarReserva(ReservaDTO dto) {
        Sala sala = salaRepository.findById(dto.salaId())
                .orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));

        // Verifica conflito de horários
        boolean conflito = reservaRepository.existsBySalaAndIniciaBeforeAndFinalizaAfter(
                sala,
                dto.finalizaDateTime(),
                dto.iniciaDateTime()
        );

        if (conflito) {
            throw new IllegalArgumentException("A sala já está reservada neste horário.");
        }

        Reserva reserva = Reserva.builder()
                .sala(sala)
                .responsavel(dto.responsavel())
                .inicia(dto.iniciaDateTime())
                .finaliza(dto.finalizaDateTime())
                .build();

        return toDTO(reservaRepository.save(reserva));
    }

    public List<ReservaDTO> getAllReservas() {
        return reservaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ReservaDTO getReservaById(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));
        return toDTO(reserva);
    }

    public void deletarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reserva não encontrada"));
        reservaRepository.delete(reserva);
    }

    private ReservaDTO toDTO(Reserva reserva) {
        return new ReservaDTO(
                reserva.getId(),
                reserva.getSala().getId(),
                reserva.getResponsavel(),
                reserva.getInicia(),
                reserva.getFinaliza()
        );
    }
}
