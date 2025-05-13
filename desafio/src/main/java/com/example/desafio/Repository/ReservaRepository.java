package com.example.desafio.Repository;


import com.example.desafio.Model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDateTime;
import com.example.desafio.Model.Sala;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {


    List<Reserva> findBySala(Sala sala);


    List<Reserva> findByIniciaAfter(LocalDateTime now);


    boolean existsBySalaAndIniciaBeforeAndFinalizaAfter(Sala sala, LocalDateTime finaliza, LocalDateTime inicia);
}

