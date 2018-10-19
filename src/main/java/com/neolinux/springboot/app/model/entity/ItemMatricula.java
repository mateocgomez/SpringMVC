package com.neolinux.springboot.app.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes_items")
public class ItemMatricula implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String apellido;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programa_id")
	private Programas programa;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}





	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Programas getPrograma() {
		return programa;
	}



	public void setPrograma(Programas programa) {
		this.programa = programa;
	}





	private static final long serialVersionUID = 1L;

}
