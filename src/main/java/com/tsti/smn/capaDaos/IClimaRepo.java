package com.tsti.smn.capaDaos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.Clima;

@Repository
public interface IClimaRepo extends JpaRepository<Clima, Long> {
	
	List<Clima> findByCiudadIdAndFecha(Long idCiudad, Date fecha);

	List<Clima> findByFecha(Date fecha);

	List<Clima> findByCiudadId(Long idCiudad);
}
