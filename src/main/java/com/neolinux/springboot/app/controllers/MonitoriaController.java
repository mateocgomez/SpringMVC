package com.neolinux.springboot.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.neolinux.springboot.app.model.entity.Monitoria;
import com.neolinux.springboot.app.model.service.IMonitoriaService;

@Controller
@SessionAttributes("monitoria")
public class MonitoriaController {
	
	@Autowired
//	@Qualifier() PARA SELECCION EL BEANS CORRECTO
	private IMonitoriaService monitoriaService;
	
	@GetMapping(value = "/ver/{id}")
	public String ver(@PathVariable(value= "id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		Monitoria monitoria = monitoriaService.findOne(id);
		if (monitoria == null) {
			flash.addFlashAttribute("error", "La monitoria no existe en la base de datos");
			return "redirect:/listar";
		}
		model.put("monitoria", monitoria);
		model.put("titulo", "Detalle monitoria: " + monitoria.getNombre());
		return "ver";
	}
	
	@RequestMapping(value="/listar", method=RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de cursos disponibles");
		model.addAttribute("monitorias", monitoriaService.findAll());
		return "listar";
	}
	
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model) {
		
		
		
		Monitoria monitoria = new Monitoria();
		model.put("monitoria", monitoria);
		model.put("titulo", "Formulario de Curso");
		return "form";
	}
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Monitoria monitoria, BindingResult result, Model model,RedirectAttributes flash,SessionStatus status) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Curso");
			return "form";
		}
		String mensajeFlash = (monitoria.getId() != null)? "Monitoria editada con exito" : "Monitoria creada con exito";
		
		monitoriaService.save(monitoria);
		status.setComplete();
		flash.addFlashAttribute("sucess",mensajeFlash);
		return "redirect:listar";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash) {
		
		Monitoria monitoria = null;
		
		if (id>0) {
			monitoria = monitoriaService.findOne(id);
			if(monitoria == null) {
				flash.addFlashAttribute("error", "El id de la monitoria no existe");
				return "redirect:/listar";
			}
		}else {
			flash.addFlashAttribute("error", "El id de la monitoria no puede ser nulo");
			return "redirect:/listar";
		}
		model.put("monitoria", monitoria);
		model.put("titulo", "Editar Monitoria");
		return "form";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")Long id, RedirectAttributes flash) {
		
		if (id > 0) {
			monitoriaService.delete(id);
			flash.addFlashAttribute("error", "Monitoria eliminado exitosamente");
		}
		
		return "redirect:/listar";
	}

}
