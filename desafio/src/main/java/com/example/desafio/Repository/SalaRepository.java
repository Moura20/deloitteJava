package com.example.desafio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.desafio.Model.Sala;
import java.util.Optional;



public interface SalaRepository extends JpaRepository<Sala, Long> {
    Optional<Sala> findByNome(String nome);
}
