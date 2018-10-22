package com.neolinux.springboot.app.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neolinux.springboot.app.model.dao.IEstudianteDao;
import com.neolinux.springboot.app.model.dao.IMonitoriaDao;
import com.neolinux.springboot.app.model.dao.IProgramaDao;
import com.neolinux.springboot.app.model.entity.Programas;
import com.neolinux.springboot.app.model.entity.Estudiante;
import com.neolinux.springboot.app.model.entity.Monitoria;

@Service
public class MonitoriaServiceImpl implements IMonitoriaService {

	@Autowired
	private IMonitoriaDao monitoriaDao;
	
	@Autowired
	private IProgramaDao programaDao;
	
	@Autowired
	private IEstudianteDao estudianteDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<Monitoria> findAll() {
		// TODO Auto-generated method stub
		return (List<Monitoria>) monitoriaDao.findAll();
	}

	@Override
	@Transactional
	public void save(Monitoria monitoria) {
		monitoriaDao.save(monitoria);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Monitoria findOne(Long id) {
		// TODO Auto-generated method stub
		return monitoriaDao.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		monitoriaDao.delete(id);
		
	}

	@Override
	public List<Programas> findByNombre(String term) {
		// TODO Auto-generated method stub
		return programaDao.findByNombre(term);
	}

	@Override
	@Transactional
	public void saveEstudiante(Estudiante estudiante) {
		// TODO Auto-generated method stub
		estudianteDao.save(estudiante);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Programas findProgramaById(Long id) {
		// TODO Auto-generated method stub
		return programaDao.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Estudiante findEstudianteById(Long id) {
		// TODO Auto-generated method stub
		return estudianteDao.findOne(id);
	}

}
