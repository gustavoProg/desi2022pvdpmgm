package com.tsti.smn.capaPresentacion.climaExtendido;

import java.util.Date;


public class ClimaExtendidoBuscarForm {

	private Date fecha;

	private Long idCiudad;

	
	public ClimaExtendidoBuscarForm() {
		super();
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
}
