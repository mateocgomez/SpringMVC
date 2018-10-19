package com.neolinux.springboot.app.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neolinux.springboot.app.model.entity.Programas;


public interface IProgramaDao extends CrudRepository<Programas, Long> {
	
	@Query("select p from Programas p where p.codigo like %?1%")
	public List<Programas> findByNombre(String term);

}
