package com.boot.mvc.web.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.boot.mvc.domain.Cargo;
import com.boot.mvc.service.CargoService;

@Component
public class SpringToCargoConverter implements Converter<String, Cargo>{

	@Autowired
	private CargoService cargoService;
	
	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		return this.cargoService.findById(Long.parseLong(text));
	}

}
