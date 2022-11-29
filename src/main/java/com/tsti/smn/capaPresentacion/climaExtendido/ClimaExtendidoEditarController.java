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

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaExtendidoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.ClimaExtendido;



@Controller
@RequestMapping("/climaExtendidoEditar")
public class ClimaExtendidoEditarController {

	@Autowired
    private ClimaExtendidoService service;
	
	@Autowired
    private CiudadService serviceCiudad;
	
    @RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
    public String preparaForm(
    		Model modelo, @PathVariable("id") Optional<Long> idClimaExtendido) throws Exception {
    	
    	if (idClimaExtendido.isPresent()) {
    		
    		ClimaExtendido entity = service.getClimaExtendidoById(idClimaExtendido.get());
    		
    		ClimaExtendidoForm form = new ClimaExtendidoForm(entity);
			
    		modelo.addAttribute("formBean", form);
		
    	} else {
    		
    		ClimaExtendidoForm nuevoClimaExtendido = new ClimaExtendidoForm();
    		
    		nuevoClimaExtendido.setFecha(new Date());
    		
    		modelo.addAttribute("formBean", nuevoClimaExtendido);
		}
    	return "climaExtendidoEditar";
    }

    
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllCiudades() {
 
    	return this.serviceCiudad.getAll();
    }	

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteClimaExtendidoById(Model model, @PathVariable("id") Long id) 
	{
		service.deleteClimaExtendidoByid(id);
	
		return "redirect:/climaExtendidoBuscar";
	}
	
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") /*@Valid*/  
    	ClimaExtendidoForm formBean, BindingResult result,
    	ModelMap modelo, @RequestParam String action) {
    	
    	if(action.equals("Aceptar"))
    	{
    		//FieldError error = new FieldError("formBean","fechaNacimiento","la fecha de nacimiento es incorrecta.");
            //result.addError(error);
            
    		if(result.hasErrors())
    		{
    			modelo.addAttribute("formBean",formBean);
    			
    			return "climaExtendidoEditar";
    		}
    		else
    		{
    			ClimaExtendido c = formBean.toPojo();
    			
    			//c.setFecha(new Date());
    			
    			c.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));
    			
    			service.save(c);
    			
    			return "redirect:/climaExtendidoBuscar";
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
