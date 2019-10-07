package com.boot.mvc.web.controller;

import java.time.LocalDate;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.JodaTimeConverters.DateTimeToDateConverter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.boot.mvc.domain.Cargo;
import com.boot.mvc.domain.Endereco;
import com.boot.mvc.domain.Funcionario;
import com.boot.mvc.domain.UF;
import com.boot.mvc.service.CargoService;
import com.boot.mvc.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService FuncionarioService;
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario,Endereco endereco) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", this.FuncionarioService.findAll());
		return "/funcionario/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		
		if(funcionario.getId() == null) {
			this.FuncionarioService.save(funcionario);
			attr.addFlashAttribute("success","Funcionario inserido com sucesso!");
		}else {
			this.FuncionarioService.update(funcionario);
			attr.addFlashAttribute("success","Funcionario editado com sucesso!");
		}
		return "redirect:/funcionarios/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id,ModelMap model ) {
		Funcionario f = null;
		f = this.FuncionarioService.findById(id);
		model.addAttribute("funcionario", f);
		return"/funcionario/cadastro";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id")Long id,RedirectAttributes attr) {
		this.FuncionarioService.delete(id);
		attr.addFlashAttribute("success","Funcionario excluido com sucesso!");
		return "redirect:/funcionarios/listar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> getCargos(){
		return this.cargoService.findAll(); 
	}
	
	@ModelAttribute("ufs")
	public UF[] getUfs() {
		return UF.values();
	}
	
	@GetMapping("/buscar/nome")
	public String findByNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("funcionarios", this.FuncionarioService.findByNome(nome));
		return "funcionario/lista";
	}
	
	@GetMapping("/buscar/cargo")
	public String findByCargo(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("funcionarios", this.FuncionarioService.findByCargo(id));
		return "funcionario/lista";
	}
	
	
	@GetMapping("/buscar/data")
	public String findByDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
			@RequestParam("saida")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida, ModelMap model) {
		model.addAttribute("funcionarios", this.FuncionarioService.findByDatas(entrada,saida));
		return "funcionario/lista";
	}


}
