package com.tsti.smn.capaPresentacion.eventoExtremo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.EstadoClimaService;
import com.tsti.smn.capaServicios.EventoExtremoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.EventoExtremo;

@Controller
@RequestMapping("/eventoExtremoCrear")
public class EventoExtremoCrearController {

	@Autowired
    private EventoExtremoService service;

	@Autowired
    private CiudadService serviceCiudad;

	@Autowired
    private EstadoClimaService serviceEstadoClima;
	
	
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(
    		Model modelo, @PathVariable("id") Optional<Long> idClima) throws Exception {
    	
    		
    		EventoExtremoForm nuevoEventoExtremo = new EventoExtremoForm();
    		
    		nuevoEventoExtremo.setFecha(new Date());
    		
    		modelo.addAttribute("formBean", nuevoEventoExtremo);

    		return "eventoExtremoCrear";
    }

    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
 
    	return this.serviceCiudad.getAll();
    }

   
    @ModelAttribute("allEventosExtremos")
    public List<EventoExtremo> getAllEventosExtremos() {
 
    	return this.service.getAll();
    }
    
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid  
        EventoExtremoForm formBean, BindingResult result,
    	ModelMap modelo, @RequestParam String action) {
    	
    	if(action.equals("Aceptar"))
    	{
    		//FieldError error = new FieldError("formBean","fechaNacimiento","la fecha de nacimiento es incorrecta.");
            //result.addError(error);
            
    		if(result.hasErrors())
    		{
    			modelo.addAttribute("formBean",formBean);
    			
    			return "eventoExtremoCrear";
    		}
    		else
    		{
    			EventoExtremo e = formBean.toPojo();
    			
    			e.setFecha(new Date());
    			
    			e.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
    			
    			service.save(e);
    			
    			ArrayList<String> alertasEnviadas = service.enviarCorreos(e);
    			
    			if (alertasEnviadas.size() == 0)
    			{
    				alertasEnviadas.add("Ninguna alerta fue enviada, No hay subscripciones.");
    			}
    			
    			modelo.addAttribute("resultados",alertasEnviadas);

    			return "eventoExtremoCrear";
    		}
    	}
    	if(action.equals("Cancelar"))
    	{
    		modelo.clear();

    		return "redirect:/";
    	}
    	return "redirect:/";
    }
}
