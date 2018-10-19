package com.neolinux.springboot.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.neolinux.springboot.app.model.entity.Estudiante;

public interface IEstudianteDao extends CrudRepository<Estudiante, Long> {

}
