
package com.boot.mvc.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.mvc.dao.FuncionarioDao;
import com.boot.mvc.domain.Funcionario;

@Transactional(readOnly = false)
@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioDao dao;

	@Override
	public void save(Funcionario funcionario) {
		this.dao.save(funcionario);

	}

	@Override
	public void update(Funcionario funcionario) {
		this.dao.update(funcionario);

	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);

	}

	@Override
	public Funcionario findById(Long id) {

		return this.dao.findById(id);
	}

	@Override
	public List<Funcionario> findAll() {

		return this.dao.findAll();
	}

	@Override
	public List<Funcionario> findByNome(String nome) {

		return this.dao.findByNome(nome);
	}

	@Override
	public List<Funcionario> findByCargo(Long id) {

		return this.dao.findByCargo(id);
	}

	@Override
	public List<Funcionario> findByDatas(LocalDate entrada, LocalDate saida) {

		if (entrada != null && saida != null) {
			return this.dao.findByDatas(entrada, saida);
		
		} else if (entrada != null) {
			return this.dao.findByDataEntrada(entrada);
		
		} else if (saida != null) {
			return this.dao.findByDataSaida(saida);

		} else {

			List<Funcionario> lista = new ArrayList<>();
			return lista;
		}

	}

}
