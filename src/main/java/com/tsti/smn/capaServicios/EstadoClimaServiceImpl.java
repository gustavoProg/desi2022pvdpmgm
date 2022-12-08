package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IEstadoClimaRepo;
import com.tsti.smn.pojos.EstadoClima;

@Service
public class EstadoClimaServiceImpl implements EstadoClimaService {

	@Autowired
	IEstadoClimaRepo repo;
	
	
	@Override
	public List<EstadoClima> getAll() {
	
		return repo.findAll();
	}



	@Override
	public EstadoClima getById(Long idEstadoClima) {
		
		return repo.findById(idEstadoClima).get();
	}
	

}
