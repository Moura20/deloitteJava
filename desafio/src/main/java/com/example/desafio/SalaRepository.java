package com.example.desafio;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.desafio.Sala;
import java.util.Optional;



public interface SalaRepository extends JpaRepository<Sala, Long> {
    Optional<Sala> findByNome(String nome);
}
