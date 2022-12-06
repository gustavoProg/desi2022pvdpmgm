package com.tsti.smn.capaPresentacion.eventoExtremo;

import java.util.ArrayList;
import java.util.Date;

import com.tsti.smn.pojos.EventoExtremo;


public class EventoExtremoForm {

	private Long idEventoExtremo;

	private Date fecha;

	private Long idProvincia;

	private Long idCiudad;

	private String descripcion;

	private ArrayList<String> alertasEnviadas;
	
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

	
	
	public ArrayList<String> getAlertasEnviadas() {
		return alertasEnviadas;
	}

	public void setAlertasEnviadas(ArrayList<String> alertasEnviadas) {
		this.alertasEnviadas = alertasEnviadas;
	}

	public EventoExtremo toPojo()
	{
		EventoExtremo eventoExtremo = new EventoExtremo();
		eventoExtremo.setFecha(this.getFecha());
		eventoExtremo.setDescripcion(this.getDescripcion());
		return eventoExtremo;
	}
	
	
}
