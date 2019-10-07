package com.boot.mvc.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.mvc.domain.Cargo;
import com.boot.mvc.domain.Departamento;
import com.boot.mvc.service.CargoService;
import com.boot.mvc.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result,RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			return"/cargo/cadastro";
		}
		
		if(cargo.getId() == null) {
			this.cargoService.save(cargo);
			attr.addFlashAttribute("success","Cargo inserido com sucesso!");
			
		}else {
			
			this.cargoService.update(cargo);
			attr.addFlashAttribute("success","Cargo editado com sucesso!");
		}
		return"redirect:/cargos/cadastrar";
		
	}
	
	/**
	 * responsavel por preencher a combo de departamentos
	 * @return List<Departamento>
	 */
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return this.departamentoService.findAll();
	}
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", this.cargoService.findAll());
		return "/cargo/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model) {
		model.addAttribute("cargo", this.cargoService.findById(id));
		
		return"/cargo/cadastro";
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		
		if(this.cargoService.cargoTemFuncionario(id)){
			attr.addFlashAttribute("success","Cargo não excluido. Possui Funcionarios Vinculado(s)");
			return "redirect:/cargos/listar";

		}else {
			
			this.cargoService.delete(id);		
			attr.addFlashAttribute("success","Cargo excluido com sucesso!");
		}
		
		return "redirect:/cargos/listar";
	}
	
}
