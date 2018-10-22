package com.neolinux.springboot.app.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neolinux.springboot.app.model.dao.IProgramaDao;
import com.neolinux.springboot.app.model.entity.Programas;

@Controller
public class ProgramasController {

	@Autowired
	private IProgramaDao programaDao;
	
	@RequestMapping(value="/alumnos")
	public String crear(Map<String, Object> model) {
		
		Programas programa = new Programas();
		model.put("programa", programa);
		model.put("titulo", "Formulario del alumno");
		return "alumnos";
	}
	
	@RequestMapping(value="/alumnos", method=RequestMethod.POST)
	public String guardar(Programas programa) {
		programaDao.save(programa);
		return "redirect:listar";
	}
	
}
