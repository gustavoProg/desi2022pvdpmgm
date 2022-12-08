package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.capaPresentacion.clima.ClimaBuscarForm;
import com.tsti.smn.pojos.Clima;

public interface ClimaService {

	List<Clima> getAll();

	List<Clima> filter(ClimaBuscarForm filter);

	void save(Clima clima) throws Exception;

	Clima getClimaById(Long idClima) throws Exception;

	void deleteClimaByid(Long id);
}
