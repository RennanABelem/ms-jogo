package com.jogo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.jogo.dto.ContaDto;
import com.jogo.model.Conta;
import com.jogo.repository.ContaRepository;
import com.jogo.service.ContaService;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private ContaRepository contaRepository;
	
	@Value("${fila-conta}")
	private String FILA_CONTA;

	@Override
	public List<Conta> buscarTodos() {
		return contaRepository.findAll();
	}

	@Override
	public Conta salvar(ContaDto contaDto) {
		Conta conta = new Conta();
		conta.setEmail(contaDto.getEmail());
		conta.setNome(contaDto.getNome());
		conta.setCodename(contaDto.getCodename());
		this.publicarMensagem(contaRepository.save(conta));

		return conta;
	}

	private void publicarMensagem(Conta conta) {
		jmsTemplate.convertAndSend(FILA_CONTA, conta);
	}

}
