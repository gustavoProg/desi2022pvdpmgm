/**
 * @author kuttel
 *
 */
package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.ICiudadRepo;
import com.tsti.smn.capaPresentacion.ciudades.CiudadesBuscarForm;
import com.tsti.smn.pojos.Ciudad;

@Service
public class CiudadServiceImpl implements CiudadService {
//	Logger LOG = LoggerFactory.getLogger(CiudadService.class);
//	
	@Autowired
	ICiudadRepo repo;

	@Override
	public List<Ciudad> getAll() {

		return repo.findAll();
	}



	@Override
	public Ciudad getById(Long idCiudad) {

		return repo.findById(idCiudad).get();
	}
	
	@Override
	public List<Ciudad> filter(CiudadesBuscarForm filter)
	{
		//ver https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
		if(filter.getNombre()==null && filter.getProvinciaSeleccionada()==null)
			return repo.findAll();
		else
			return repo.findByNombreOrIdProvincia(filter.getNombre(),filter.getProvinciaSeleccionada());
	}


	@Override
	public void deleteByid(Long id) {
		repo.deleteById(id);
		
	}



	@Override
	public void save(Ciudad c) {
		repo.save(c);
		
	}

}
