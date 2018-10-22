package com.neolinux.springboot.app.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "monitorias")
public class Monitoria implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

//	especificamos que es la llave y que es autocrimental
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String salon;

	@NotEmpty
	private String horario;
	
	@OneToMany(mappedBy="monitoria", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Estudiante> estudiantes;
	
	

	public Monitoria() {
	   estudiantes = new ArrayList<Estudiante>();
	}

	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date createAt;

//	@PrePersist
//	public void prePersist() {
//		createAt = new Date();
//	}  ESTO SIRVE CUANDO LA FECHA SE VA AGREGAR AUTOMATICAMENTE

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

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public void addEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}
