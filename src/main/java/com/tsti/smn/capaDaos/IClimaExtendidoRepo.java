package com.tsti.smn.capaDaos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tsti.smn.pojos.ClimaExtendido;

@Repository
public interface IClimaExtendidoRepo extends JpaRepository<ClimaExtendido, Long> {
	
	
	List<ClimaExtendido> findByCiudadIdAndFechaAfter(Long idCiudad, Date fecha);

}
