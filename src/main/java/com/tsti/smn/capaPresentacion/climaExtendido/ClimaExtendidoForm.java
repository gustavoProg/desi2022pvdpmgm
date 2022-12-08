package com.tsti.smn.capaPresentacion.climaExtendido;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.ClimaExtendido;
/**import com.tsti.smn.pojos.Persona;*/
/**
 * Objeto necesario para insertar o eliminar un Clima Extendido. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, lo cual resulta mas sencillo de representar en JSON
 *
 */
public class ClimaExtendidoForm {

	private Long idClimaExtendido;
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fecha;
	
	@NotNull
	private Long idCiudad;

	@NotNull
	@Min(value = 0, message = "El % >=0")
	private Float probabilidad;

	@NotNull
	@Min(value = 0, message = "Debe ser >=0")
	private Float cantidadLluvias;
	
	@NotNull
	@Size(min=0, max=500, message = "caracteres <= 500")
	private String descripcion;
	
	public ClimaExtendidoForm() {
		super();
	}

	public ClimaExtendidoForm(ClimaExtendido c) {
		super();
		//this.idClimaExtendido = c.getIdClimaExtendido();
		this.fecha = c.getFecha();
		this.idCiudad = c.getCiudad().getId();
		this.probabilidad = c.getProbabilidad();
		this.cantidadLluvias = c.getCantidadLluvias();
		this.descripcion = c.getDescripcion();
	}

	
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
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
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
	
	public ClimaExtendido toPojo()
	{
		ClimaExtendido climaExtendido = new ClimaExtendido();
		climaExtendido.setIdClimaExtendido(this.getIdClimaExtendido());
		climaExtendido.setFecha(this.getFecha());
		climaExtendido.setProbabilidad(this.getProbabilidad());
		climaExtendido.setCantidadLluvias(this.getCantidadLluvias());
		climaExtendido.setDescripcion(this.getDescripcion());
		return climaExtendido;
	}
}
