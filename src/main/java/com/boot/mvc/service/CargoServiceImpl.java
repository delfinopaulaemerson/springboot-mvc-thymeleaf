package com.boot.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.boot.mvc.dao.CargoDao;
import com.boot.mvc.domain.Cargo;

@Transactional(readOnly = false)
@Controller
public class CargoServiceImpl implements CargoService {

	@Autowired
	private CargoDao dao;
	
	@Transactional(readOnly = true)
	@Override
	public void save(Cargo cargo) {
		this.dao.save(cargo);
		
	}

	@Transactional(readOnly = true)
	@Override
	public void update(Cargo cargo) {
		this.dao.update(cargo);
		
	}

	@Transactional(readOnly = true)
	@Override
	public void delete(Long id) {
		this.dao.delete(id);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Cargo findById(Long id) {
		
		return this.dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cargo> findAll() {
		
		return this.dao.findAll();
	}

}
