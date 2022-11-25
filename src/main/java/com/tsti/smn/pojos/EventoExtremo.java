package com.tsti.smn.pojos;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EventoExtremo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEventoExtremo;

	private Date fecha;

	private Long idProvincia;

	@ManyToOne
	private Ciudad ciudad;
	
	private String descripcion;
	
	public EventoExtremo() {
		super();
	}

	public EventoExtremo(EventoExtremo e) {
		super();
		this.idEventoExtremo = e.getIdEventoExtremo();
		this.fecha = e.getFecha();
		this.ciudad = e.getCiudad();
		this.descripcion = e.getDescripcion();
	}


	public Long getIdEventoExtremo() {
		return idEventoExtremo;
	}

	public void setIdEventoExtremo(Long idEventoExtremo) {
		this.idEventoExtremo = idEventoExtremo;
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

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
