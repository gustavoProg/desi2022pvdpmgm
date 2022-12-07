package com.tsti.smn.capaPresentacion.eventoExtremo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.EventoExtremo;


public class EventoExtremoForm {

	private Long idEventoExtremo;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fecha;

	private Long idCiudad;

	private String descripcion;

	public EventoExtremoForm() {
		super();
	}

	public EventoExtremoForm(EventoExtremo e) {
		super();
		this.idEventoExtremo = e.getIdEventoExtremo();
		this.fecha = e.getFecha();
		this.idCiudad = e.getCiudad().getId();
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

	public Long getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public EventoExtremo toPojo()
	{
		EventoExtremo eventoExtremo = new EventoExtremo();
		eventoExtremo.setFecha(this.getFecha());
		eventoExtremo.setDescripcion(this.getDescripcion());
		return eventoExtremo;
	}
	
	
}
