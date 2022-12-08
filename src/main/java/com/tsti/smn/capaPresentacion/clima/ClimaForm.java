package com.tsti.smn.capaPresentacion.clima;

import java.util.Date;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.Clima;


public class ClimaForm {

	private Long idClima;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date fecha;

	@NotNull
	private Long idCiudad;

	@Max(value = 50, message = "La máxima temperatura posible es 50°C.")
	@Min(value = 0, message = "La mínima temperatura posible es 0°C.")
	private Float temperatura;

	@Max(value = 100, message = "La máxima humedad posible es 100%.")
	@Min(value = 0, message = "La mínima humedad posible es 0%.")
	private Float humedad;

	@NotNull
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
