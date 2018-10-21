package com.neolinux.springboot.app.model.service;

import java.util.List;

import com.neolinux.springboot.app.model.entity.Programas;
import com.neolinux.springboot.app.model.entity.Estudiante;
import com.neolinux.springboot.app.model.entity.Monitoria;

public interface IMonitoriaService {
	
	public List<Monitoria> findAll();
	
	public void save(Monitoria monitoria);
	
	public Monitoria findOne(Long id);
	
	public void delete(Long id);
	
	public List<Programas> findByNombre(String term);
	
	
	public void saveEstudiante(Estudiante estudiante);
	
	
	//obtener el programa por el id
	
	public Programas findProgramaById(Long id);
}
