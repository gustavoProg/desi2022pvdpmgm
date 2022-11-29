package com.tsti.smn.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ClimaExtendido {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClimaExtendido;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@ManyToOne
	private Ciudad ciudad;

	private Float probabilidad;

	private Float cantidadLluvias;
	
	private String descripcion;
	
	public Long getIdClimaExtendido() {
		return idClimaExtendido;
	}
	public void setIdClimaExtendido(Long idClimaExtendido) {
		this.idClimaExtendido = idClimaExtendido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Float getProbabilidad() {
		return probabilidad;
	}
	public void setProbabilidad(Float probabilidad) {
		this.probabilidad = probabilidad;
	}
	public Float getCantidadLluvias() {
		return cantidadLluvias;
	}
	public void setCantidadLluvias(Float cantidadLluvias) {
		this.cantidadLluvias = cantidadLluvias;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
