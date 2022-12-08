package com.tsti.smn.capaPresentacion.climaExtendido;

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

//import com.tsti.smn.capaPresentacion.personas.PersonasBuscarForm;
import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaExtendidoService;
//import com.tsti.smn.capaServicios.EstadoClimaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.ClimaExtendido;
//import com.tsti.smn.pojos.Persona;


@Controller
@RequestMapping("/climaExtendidoBuscar")
public class ClimaExtendidoBuscarController {

	@Autowired
    private ClimaExtendidoService service;
	
	@Autowired
    private CiudadService serviceCiudad;
	
	//No Utilizado
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) {
    	
    	ClimaExtendidoBuscarForm form =  new ClimaExtendidoBuscarForm();
    	
    	//form.setFecha(new Date());
   	
    	modelo.addAttribute("formBean",form);
    	
    	return "climaExtendidoBuscar";
    }
     
    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
        return this.serviceCiudad.getAll();
    }

    
    @RequestMapping( method=RequestMethod.POST)
    public String submit( 
    		ClimaExtendidoBuscarForm formBean,
    		BindingResult result, 
    		ModelMap modelo,
    		@RequestParam String action) {
    	
    	if(action.equals("Buscar"))
    	{
    		List<ClimaExtendido> climaExtendido = service.filter(formBean);
    		
        	modelo.addAttribute("formBean",formBean);
        	
        	modelo.addAttribute("resultados",climaExtendido);
        	
        	return "climaExtendidoBuscar";
    	}
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		
    		return "redirect:/";
    	}
    	if(action.equals("Registrar"))
    	{
    		modelo.clear();
    		
    		return "redirect:/climaExtendidoEditar";
    	}
    	return "redirect:/";
    }
}
