package com.boot.mvc.dao;

import org.springframework.stereotype.Repository;

import com.boot.mvc.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

}
