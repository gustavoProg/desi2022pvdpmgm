package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IEventoExtremoRepo;
import com.tsti.smn.capaDaos.IPersonaRepo;
import com.tsti.smn.pojos.EventoExtremo;
import com.tsti.smn.pojos.Persona;

@Service
public class EventoExtremoServiceImpl implements EventoExtremoService {

	@Autowired
	IEventoExtremoRepo repo;

	@Autowired
	IPersonaRepo repoPersona;

	@Autowired
	private JavaMailSender mailSender;

	
	
	@Override
	public List<EventoExtremo> getAll() {
		return repo.findAll();
	}

	
	@Override
	public void save(EventoExtremo eventoExtremo) {

		repo.save(eventoExtremo);
	}
	

	@Override
	public boolean enviarCorreos(EventoExtremo eventoExtremo) {

		try {
			
			List<Persona> personas = repoPersona.findAll();
			
	        for (Persona p : personas) 
	        { 

	            if(p.getRecibirAlertas() && p.getCiudad().getId() == eventoExtremo.getCiudad().getId())
	            {
	                SimpleMailMessage email = new SimpleMailMessage();
	                
		            email.setTo(p.getCorreo());
		
		            email.setSubject("Alerta de Evento Extremo!!!");
		            
		            email.setText(eventoExtremo.getDescripcion());
		
		            mailSender.send(email);
	            }
	        }

		} catch (Exception e) {
			
			return false;
		}
        
        return true;
    }
}
