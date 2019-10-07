package com.boot.mvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.mvc.domain.Funcionario;

@Transactional(readOnly = false)
@Service
public interface FuncionarioService {

	void save(Funcionario funcionario);

	void update(Funcionario funcionario);

	void delete(Long id);

	Funcionario findById(Long id);

	List<Funcionario> findAll();

	List<Funcionario> findByNome(String nome);

	List<Funcionario> findByCargo(Long id);

	List<Funcionario> findByDatas(LocalDate entrada, LocalDate saida);

}
