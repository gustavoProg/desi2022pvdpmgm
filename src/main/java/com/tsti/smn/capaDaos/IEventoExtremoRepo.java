package com.tsti.smn.capaDaos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.EventoExtremo;

@Repository
public interface IEventoExtremoRepo extends JpaRepository<EventoExtremo, Long> {
	
}
