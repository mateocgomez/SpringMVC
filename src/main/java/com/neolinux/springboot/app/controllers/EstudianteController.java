package com.neolinux.springboot.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neolinux.springboot.app.model.entity.Programas;
import com.neolinux.springboot.app.model.entity.Estudiante;
import com.neolinux.springboot.app.model.entity.Monitoria;
import com.neolinux.springboot.app.model.service.IMonitoriaService;

@Controller
@RequestMapping("/estudiante")
@SessionAttributes("estudiante")
public class EstudianteController {

	@Autowired
	private IMonitoriaService monitoriaService;

	@GetMapping("/form/{monitoriaId}")
	public String crear(@PathVariable(value = "monitoriaId") Long monitoriaId, Map<String, Object> model,
			RedirectAttributes flash) {

		Monitoria monitoria = monitoriaService.findOne(monitoriaId);

		if (monitoria == null) {

			flash.addFlashAttribute("error", "La monitoria no existe en la base de datos");
			return "redirect:/listar";

		}

		Estudiante estudiante = new Estudiante();
		estudiante.setMonitoria(monitoria);

		model.put("estudiante", estudiante);
		model.put("titulo", "Llena los datos para inscribirte");

		return "estudiante/form";
	}

	@GetMapping(value = "/cargar-descuento/{term}", produces = { "application/json" })
	public @ResponseBody List<Programas> cargarPrograma(@PathVariable String term) {
		return monitoriaService.findByNombre(term);
	}

}
