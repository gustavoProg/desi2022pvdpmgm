package com.tsti.smn.capaPresentacion.personas;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.tsti.smn.pojos.Persona;

/**
 * Objeto necesario para insertar o eliminar una persona. 
 * Nótese que en lugar de referenciar al objeto Ciudad, reemplaza ese atributo por el idCiudad, lo cual resulta mas sencillo de representar en JSON
 *
 */
public class PersonaForm {

	@NotNull(message = "El dni no puede ser nulo")
	@Min(value = 1000000, message = "El dni debe ser mayor a 1000000")
	private Long dni;

	@NotNull
	@Size(min=2, max=30, message = "Apellido invalido.")
	private String apellido;

	@NotNull
	@Size(min=2, max=30, message = "Nombre invalido.")
	private String nombre;

	@NotNull
	private Long idCiudad;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaNacimiento;

	@Email(message="Correo invalido.")
	private String correo;

	private Boolean recibirAlertas;
	
	
	public PersonaForm() {
		super();
	}
	
	public PersonaForm(Persona p) {
		super();
		this.nombre=p.getNombre();
		this.apellido=p.getApellido();
		this.dni=p.getDni();
		this.idCiudad=p.getCiudad().getId();
		this.fechaNacimiento=p.getFechaNacimiento();
		this.correo=p.getCorreo();
		this.recibirAlertas=p.getRecibirAlertas();
	}
	
	
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Boolean getRecibirAlertas() {
		return recibirAlertas;
	}
	public void setRecibirAlertas(Boolean recibirAlertas) {
		this.recibirAlertas = recibirAlertas;
	}
	
	public Persona toPojo()
	{
		Persona p = new Persona();
		p.setDni(this.getDni());
		p.setApellido(this.getApellido());
		p.setNombre(this.getNombre());
		p.setDni(this.getDni());
		p.setFechaNacimiento(this.getFechaNacimiento());
		p.setCorreo(this.getCorreo());
		p.setRecibirAlertas(this.getRecibirAlertas());
		return p;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
