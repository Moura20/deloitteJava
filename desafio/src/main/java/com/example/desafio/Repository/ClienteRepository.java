package com.example.desafio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.desafio.Model.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long>  {

}
