package com.tsti.smn.capaServicios;


import java.util.List;

import com.tsti.smn.capaPresentacion.ciudades.CiudadesBuscarForm;
import com.tsti.smn.pojos.Ciudad;


public interface CiudadService {

	List<Ciudad> getAll();
	
	Ciudad getById(Long idCiudad) ;
	
	List<Ciudad> filter(CiudadesBuscarForm filter);

	void deleteByid(Long id);

	void save(Ciudad c);

}
