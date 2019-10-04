package com.boot.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.mvc.dao.FuncionarioDao;
import com.boot.mvc.domain.Funcionario;

@Transactional(readOnly = false)
@Service
public class FuncionarioServiceImpl implements FuncionarioService{
	
	@Autowired
	private FuncionarioDao dao;

	@Transactional(readOnly = true)
	@Override
	public void save(Funcionario funcionario) {
		this.dao.save(funcionario);
		
	}

	@Transactional(readOnly = true)
	@Override
	public void update(Funcionario funcionario) {
	this.dao.update(funcionario);
		
	}

	@Transactional(readOnly = true)
	@Override
	public void delete(Long id) {
		this.dao.delete(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Funcionario findById(Long id) {
		
		return this.dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Funcionario> findAll() {
		
		return this.dao.findAll();
	}

}
