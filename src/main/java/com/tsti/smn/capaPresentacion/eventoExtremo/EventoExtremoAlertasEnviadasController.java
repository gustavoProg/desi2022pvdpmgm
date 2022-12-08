package com.tsti.smn.capaPresentacion.eventoExtremo;

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

import com.tsti.smn.capaServicios.EventoExtremoService;
import com.tsti.smn.pojos.EventoExtremo;


@Controller
@RequestMapping("/eventoExtremoAlertasEnviadas")
public class EventoExtremoAlertasEnviadasController {

	@Autowired
    private EventoExtremoService service;
	
    @RequestMapping(method=RequestMethod.GET)
    public String preparaForm(Model modelo) throws Exception {

    		EventoExtremoAlertasEnviadasForm alertas = new EventoExtremoAlertasEnviadasForm();
    		
    		alertas.setListaAlertasEnviadas(service.getAll());
    		
    		modelo.addAttribute("resultados", alertas);

    		return "eventoExtremoAlertasEnviadas";
    }
    
    
    @RequestMapping( method=RequestMethod.POST)
    public String submit(@RequestParam String action) {
    	
    	return "redirect:/";
    }
}
