package com.tsti.smn.capaServicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

	public EventoExtremo getEventoExtremoById(Long idEventoExtremo) throws Exception {

		Optional<EventoExtremo> p = repo.findById(idEventoExtremo);

		if (p != null) {
			return p.get();
		} else {
			throw new Exception("No existe la persona con el id=" + idEventoExtremo);
		}
	}

	@Override
	public void save(EventoExtremo eventoExtremo) {

		repo.save(eventoExtremo);
	}

	@Override
	public ArrayList<String> enviarCorreos(EventoExtremo eventoExtremo) {

		ArrayList<String> alertasEnviadas = new ArrayList<String>();

		List<Persona> personas = repoPersona.findAll();

		for (Persona p : personas) {

			if (p.getRecibirAlertas() && p.getCiudad().getId() == eventoExtremo.getCiudad().getId()) {
				alertasEnviadas.add(p.getCorreo());

				try {

					SimpleMailMessage email = new SimpleMailMessage();

					email.setTo(p.getCorreo());

					email.setSubject("Alerta de Evento Extremo!!!");

					email.setText(eventoExtremo.getDescripcion());

					mailSender.send(email);

				} catch (Exception e) {

				}
			}
		}
		return alertasEnviadas;
	}
}
