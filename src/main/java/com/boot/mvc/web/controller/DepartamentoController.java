package com.boot.mvc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.mvc.domain.Departamento;
import com.boot.mvc.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		
		return "/departamento/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Departamento departamento) {
		
		this.service.save(departamento);
		
		return "redirect:/departamentos/cadastrar";
	}

}
