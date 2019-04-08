package com.jogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jogo.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long>{

}
