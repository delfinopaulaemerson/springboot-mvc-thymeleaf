package com.boot.mvc.service;

import java.util.List;

import com.boot.mvc.domain.Departamento;


public interface DepartamentoService {
	
	void save(Departamento departamento);

	void update(Departamento departamento);

	void delete(Long id);

	Departamento findById(Long id);

	List<Departamento> findAll();

	boolean departamentoTemCargos(Long id);

}
