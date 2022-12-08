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
public class Clima {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClima;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@ManyToOne
	private Ciudad ciudad;

	private Float temperatura;

	private Float humedad;
	
	@ManyToOne
	private EstadoClima estadoClima;


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
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
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
	public void setHumedad(Float humedad) {
		this.humedad = humedad;
	}
	public EstadoClima getEstadoClima() {
		return estadoClima;
	}
	public void setEstadoClima(EstadoClima estadoClima) {
		this.estadoClima = estadoClima;
	}
}
