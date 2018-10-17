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
	
	private Integer creditos;
	
	private Integer valor;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="programa_id")
	private Programas programa;
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Integer getValor() {
		return valor;
	}



	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Double calcularMatricula() {
		return valor.doubleValue()- programa.getPrecio();
	}

	public Integer getCreditos() {
		return creditos;
	}



	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	private static final long serialVersionUID = 1L;

}
