package com.tsti.smn.capaServicios;

import java.util.ArrayList;
import java.util.List;

import com.tsti.smn.pojos.EventoExtremo;
import com.tsti.smn.pojos.Persona;



public interface EventoExtremoService {

	List<EventoExtremo> getAll();
	
	EventoExtremo getEventoExtremoById(Long idEventoExtremo) throws Exception;
	
	void save(EventoExtremo eventoExtremo);
	
	ArrayList<String> enviarCorreos(EventoExtremo eventoExtremo);
}
