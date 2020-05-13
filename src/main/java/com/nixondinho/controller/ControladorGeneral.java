package com.nixondinho.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inicio")
public class ControladorGeneral {

	@RequestMapping
	public String inicio() {

		return "paginaInicial";

	}

	@InitBinder
	public void miBinder(WebDataBinder binder) {

		StringTrimmerEditor metodoTrim = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, metodoTrim);
	}

}
