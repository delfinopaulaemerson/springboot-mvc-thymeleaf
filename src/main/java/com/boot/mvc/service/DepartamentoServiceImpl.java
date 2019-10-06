package com.boot.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.boot.mvc.dao.DepartamentoDao;
import com.boot.mvc.domain.Departamento;

@Transactional(readOnly = false)
@Controller
public class DepartamentoServiceImpl implements DepartamentoService {

	@Autowired
	private DepartamentoDao dao;

	@Override
	public void save(Departamento departamento) {
		this.dao.save(departamento);

	}

	@Override
	public void update(Departamento departamento) {
		this.dao.update(departamento);

	}

	@Override
	public void delete(Long id) {
		this.dao.delete(id);

	}

	@Transactional(readOnly = true)
	@Override
	public Departamento findById(Long id) {

		return this.dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Departamento> findAll() {

		return this.dao.findAll();
	}

	@Override
	public boolean departamentoTemCargos(Long id) {
		Departamento d = null;
		d = this.findById(id);

		if (d.getCargos().isEmpty()) {
			return false;
		}

		return true;
	}

}
