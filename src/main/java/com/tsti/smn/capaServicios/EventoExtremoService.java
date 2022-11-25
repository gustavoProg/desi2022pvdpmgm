package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.pojos.EventoExtremo;
import com.tsti.smn.pojos.Persona;



public interface EventoExtremoService {

	List<EventoExtremo> getAll();
	
	void save(EventoExtremo eventoExtremo);
	
	boolean enviarCorreos(EventoExtremo eventoExtremo);
}
