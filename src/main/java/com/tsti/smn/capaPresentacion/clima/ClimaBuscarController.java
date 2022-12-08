package com.tsti.smn.capaPresentacion.clima;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaPresentacion.personas.PersonasBuscarForm;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaService;
import com.tsti.smn.capaServicios.EstadoClimaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.EstadoClima;
import com.tsti.smn.pojos.Persona;


@Controller
@RequestMapping("/climaBuscar")
public class ClimaBuscarController {

	@Autowired
    private ClimaService service;
	
	@Autowired
    private CiudadService serviceCiudad;
	
	
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	
    	ClimaBuscarForm form =  new ClimaBuscarForm();
    	
    	modelo.addAttribute("formBean",form);
    	
    	return "climaBuscar";
    }
     
    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
    	
    	List<Ciudad> ciudades = this.serviceCiudad.getAll(); 
    	
    	Ciudad todas = new Ciudad();
    	todas.setNombre("Todas");
    	ciudades.add(todas);
    			
        return ciudades;
    }

    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( 
    		ClimaBuscarForm formBean,
    		BindingResult result, 
    		ModelMap modelo,
    		@RequestParam String action) {
    	
    	if(action.equals("Buscar"))
    	{
    		List<Clima> clima = service.filter(formBean);
    		
        	modelo.addAttribute("formBean",formBean);
        	
        	modelo.addAttribute("resultados",clima);
        	
        	return "climaBuscar";
    	}
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		
    		return "redirect:/";
    	}
    	if(action.equals("Registrar"))
    	{
    		modelo.clear();
    		
    		return "redirect:/climaEditar";
    	}
    	return "redirect:/";
    }
}
