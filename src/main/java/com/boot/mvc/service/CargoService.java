package com.boot.mvc.service;

import java.util.List;

import com.boot.mvc.domain.Cargo;


public interface CargoService {
	
	void save(Cargo cargo);

	void update(Cargo cargo);

	void delete(Long id);

	Cargo findById(Long id);

	List<Cargo> findAll();

	boolean cargoTemFuncionario(Long id);

}
