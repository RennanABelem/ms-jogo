package com.jogo.service;

import java.util.List;

import com.jogo.dto.ContaDto;
import com.jogo.model.Conta;

public interface ContaService {

	public List<Conta> buscarTodos();
	public Conta salvar(ContaDto contaDto);
}
