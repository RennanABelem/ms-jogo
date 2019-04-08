package com.jogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jogo.dto.ContaDto;
import com.jogo.model.Conta;
import com.jogo.service.ContaService;

@RestController
@RequestMapping("conta")
public class ContaController {

	@Autowired
	private ContaService service;
	
	@GetMapping("buscarTodos")
	public ResponseEntity<List<Conta>> buscarTodos(){
		return new ResponseEntity<List<Conta>>(service.buscarTodos(), HttpStatus.OK);
	}
	
	@PostMapping("salvar")
	public ResponseEntity<Conta> salvar(@RequestBody ContaDto contaDto){
		return new ResponseEntity<Conta>(service.salvar(contaDto), HttpStatus.CREATED);
	}
}
