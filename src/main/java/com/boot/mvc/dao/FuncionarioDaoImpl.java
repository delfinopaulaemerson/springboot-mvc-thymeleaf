package com.boot.mvc.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.boot.mvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

	@Override
	public List<Funcionario> findByNome(String nome) {
		return createQuery(" select f from Funcionario f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Funcionario> findByCargo(Long id) {
		return createQuery(" select f from Funcionario f where f.cargo.id = ?1 ", id); 
	}

	@Override
	public List<Funcionario> findByDatas(LocalDate entrada, LocalDate saida) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select f from Funcionario f where f.dataEntrada >= ?1 and f.dataSaida <= ?2 order by f.dataEntrada asc ");
		return createQuery(jpql.toString(), entrada, saida);
	}

	@Override
	public List<Funcionario> findByDataEntrada(LocalDate entrada) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select f from Funcionario f where f.dataEntrada = ?1 order by f.dataEntrada asc ");
		return createQuery(jpql.toString(), entrada);
	}

	@Override
	public List<Funcionario> findByDataSaida(LocalDate saida) {
		StringBuilder jpql = new StringBuilder();
		jpql.append(" select f from Funcionario f where f.dataSaida = ?1 order by f.dataEntrada asc ");
		return createQuery(jpql.toString(), saida);
	}
}
