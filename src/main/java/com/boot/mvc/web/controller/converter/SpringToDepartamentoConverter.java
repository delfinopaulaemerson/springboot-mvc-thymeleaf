package com.boot.mvc.web.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.boot.mvc.domain.Departamento;
import com.boot.mvc.service.DepartamentoService;

@Component
public class SpringToDepartamentoConverter implements Converter<String, Departamento> {

	@Autowired
	private DepartamentoService departamentoService;
	
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()){
			return null;
		}
		
		return this.departamentoService.findById(Long.parseLong(text));
	}

}
