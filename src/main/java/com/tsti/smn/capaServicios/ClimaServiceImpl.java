package com.tsti.smn.capaServicios;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IClimaRepo;
import com.tsti.smn.capaPresentacion.clima.ClimaBuscarForm;
import com.tsti.smn.pojos.Clima;

@Service
public class ClimaServiceImpl implements ClimaService {

	@Autowired
	IClimaRepo repo;

	@Override
	public List<Clima> getAll() {
		return repo.findAll();
	}

	@Override
	public List<Clima> filter(ClimaBuscarForm filter) {

		if (filter.getIdCiudad() == null) {
			
			if (filter.getFecha() == null)
				
				return repo.findAll();
			
			else
				return repo.findByFecha(filter.getFecha());
			
		} else {
			
			if (filter.getFecha() == null)
				
				return repo.findByCiudadId(filter.getIdCiudad());
			else
				
				return repo.findByCiudadIdAndFecha(filter.getIdCiudad(), filter.getFecha());
		}
	}

	@Override
	public void save(Clima clima) throws Exception {

		if (clima.getIdClima() == null) {

		    Calendar gc = Calendar.getInstance();
		    gc.set(Calendar.HOUR_OF_DAY, 0);
		    gc.set(Calendar.MINUTE, 0);
		    gc.set(Calendar.SECOND, 0);
		    gc.set(Calendar.MILLISECOND, 0);
			
			if (clima.getFecha().after(gc.getTime()))
				throw new Exception("Solo se pueden crear registros de clima de hoy hacia delante.");
			
			List<Clima> climaExistentes = repo.findByCiudadIdAndFecha(clima.getCiudad().getId(), clima.getFecha());

			if (climaExistentes.size() > 0)
				throw new Exception("El clima para esta ciudad ya esta existe en el sistema.");
		}
		repo.save(clima);
	}

	@Override
	public Clima getClimaById(Long idClima) throws Exception {

		Optional<Clima> clima = repo.findById(idClima);

		if (clima != null) {

			return clima.get();

		} else {

			throw new Exception("No existe la persona con el id=" + idClima);
		}
	}

	@Override
	public void deleteClimaByid(Long idClima) {
		repo.deleteById(idClima);
	}

}
