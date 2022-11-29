package com.tsti.smn.capaServicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IClimaExtendidoRepo;
import com.tsti.smn.capaPresentacion.climaExtendido.ClimaExtendidoBuscarForm;
import com.tsti.smn.pojos.ClimaExtendido;

@Service
public class ClimaExtendidoServiceImpl implements ClimaExtendidoService {

	@Autowired
	IClimaExtendidoRepo repo;
	
	/*
	 * Retorna una lista con todos los climaExtendido
	 */
	@Override
	public List<ClimaExtendido> getAll() {
		
		return repo.findAll();
	}

	/*
	 * Retorna una lista filtrada por ciudady fecha actual
	 */
	@Override
	public List<ClimaExtendido> filter(ClimaExtendidoBuscarForm filter) {
	
		return repo.findByCiudadIdAndFechaAfter(filter.getIdCiudad(), new Date());
		
}

	/*
	 * Guarda en el repositorio los datos de un clima Extendido
	 */
	@Override
	public void save(ClimaExtendido climaExtendido) {

		repo.save(climaExtendido);
	}

	/*
	 * Retorna un clima extendido si existe
	 */
	@Override
	public ClimaExtendido getClimaExtendidoById(Long idClimaExtendido) throws Exception {
			
		Optional<ClimaExtendido> climaExtendido = repo.findById(idClimaExtendido);
		
		if(climaExtendido!=null) {
			
			return climaExtendido.get();
			
		} else {
			
			throw new Exception("No existe la persona con el id="+idClimaExtendido);
		}
	}

	/*
	 * Borra un clima extendido por id
	 */
	@Override
	public void deleteClimaExtendidoByid(Long idClimaExtendido) {
		repo.deleteById(idClimaExtendido);
	}

	
}
