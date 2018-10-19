package com.neolinux.springboot.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;

	@OneToOne(fetch = FetchType.LAZY)
	private Monitoria monitoria;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "estudiante_id")
	private List<ItemMatricula> items;
	
	public Estudiante() {
		this.items = new ArrayList<ItemMatricula>();
	}

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

	public Monitoria getMonitoria() {
		return monitoria;
	}

	public List<ItemMatricula> getItems() {
		return items;
	}

	public void setItems(List<ItemMatricula> items) {
		this.items = items;
	}

	public void addItemMatricula(ItemMatricula item) {
		this.items.add(item);
	}

	public void setMonitoria(Monitoria monitoria) {
		this.monitoria = monitoria;
	}
	
	
}
