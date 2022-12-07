package com.tsti.smn.capaPresentacion.clima;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.Clima;

/**
 * Objeto necesario para insertar o eliminar una persona. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, lo cual resulta mas sencillo de representar en JSON
 *
 */
public class ClimaForm {

	private Long idClima;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fecha;

	private Long idCiudad;

	private Float temperatura;

	private Float humedad;

	private Long idEstadoClima;
	
	public ClimaForm() {
		super();
	}

	public ClimaForm(Clima c) {
		super();
		this.idClima = c.getIdClima();
		this.fecha = c.getFecha();
		this.idCiudad = c.getCiudad().getId();
		this.temperatura = c.getTemperatura();
		this.humedad = c.getHumedad();
		this.idEstadoClima = c.getEstadoClima().getId();
	}

	public Long getIdClima() {
		return idClima;
	}
	public void setIdClima(Long idClima) {
		this.idClima = idClima;
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

	public Float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Float temperatura) {
		this.temperatura = temperatura;
	}
	public Float getHumedad() {
		return humedad;
	}
	public void setHumedad(Float porcentajeHumendad) {
		this.humedad = porcentajeHumendad;
	}
	public Long getIdEstadoClima() {
		return idEstadoClima;
	}
	public void setIdEstadoClima(Long idEstadoClima) {
		this.idEstadoClima = idEstadoClima;
	}

	public Clima toPojo()
	{
		Clima clima = new Clima();
		clima.setIdClima(this.getIdClima());
		clima.setFecha(this.getFecha());
		clima.setTemperatura(this.getTemperatura());
		clima.setHumedad(this.getHumedad());
		return clima;
	}
}
