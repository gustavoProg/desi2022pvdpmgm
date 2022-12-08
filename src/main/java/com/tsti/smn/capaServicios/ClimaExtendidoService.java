package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.capaPresentacion.climaExtendido.ClimaExtendidoBuscarForm;

import com.tsti.smn.pojos.ClimaExtendido;

public interface ClimaExtendidoService {

	
	//No utilizado
	List<ClimaExtendido> getAll();

	List<ClimaExtendido> filter(ClimaExtendidoBuscarForm filter);

	void save(ClimaExtendido clima) throws Exception;

	ClimaExtendido getClimaExtendidoById(Long idClimaExtendido) throws Exception;

	void deleteClimaExtendidoByid(Long id);
}
