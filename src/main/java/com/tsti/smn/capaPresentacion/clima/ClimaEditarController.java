package com.tsti.smn.capaPresentacion.clima;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaService;
import com.tsti.smn.capaServicios.EstadoClimaService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Clima;
import com.tsti.smn.pojos.EstadoClima;

@Controller
@RequestMapping("/climaEditar")
public class ClimaEditarController {

	@Autowired
	private ClimaService service;

	@Autowired
	private CiudadService serviceCiudad;

	@Autowired
	private EstadoClimaService serviceEstadoClima;

	@RequestMapping(path = { "", "/{id}" }, method = RequestMethod.GET)
	public String preparaForm(Model modelo, @PathVariable("id") Optional<Long> idClima) throws Exception {

		if (idClima.isPresent()) {

			Clima entity = service.getClimaById(idClima.get());

			ClimaForm form = new ClimaForm(entity);

			modelo.addAttribute("formBean", form);

		} else {

			ClimaForm nuevoClima = new ClimaForm();

			nuevoClima.setFecha(new Date());

			modelo.addAttribute("formBean", nuevoClima);
		}
		return "climaEditar";
	}

	@ModelAttribute("allCiudades")
	public List<Ciudad> getAllCiudades() {

		return this.serviceCiudad.getAll();
	}

	@ModelAttribute("allEstados")
	public List<EstadoClima> getAllEstados() {

		return this.serviceEstadoClima.getAll();
	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	public String deleteClimaById(Model model, @PathVariable("id") Long id) {
		service.deleteClimaByid(id);

		return "redirect:/climaBuscar";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submit(@ModelAttribute("formBean") @Valid ClimaForm formBean, BindingResult result, ModelMap modelo,
			@RequestParam String action) throws Exception {

		if (action.equals("Aceptar")) {

			if (result.hasErrors()) {

				modelo.addAttribute("formBean", formBean);

				return "climaEditar";

			} else {
				
				Clima c = formBean.toPojo();

//				c.setFecha(new Date());

				c.setCiudad(serviceCiudad.getById(formBean.getIdCiudad()));

				c.setEstadoClima(serviceEstadoClima.getById(formBean.getIdEstadoClima()));

				try {
					
					service.save(c);

					return "redirect:/climaBuscar";

				} catch (Exception e) {

					ObjectError error = new ObjectError("globalError", e.getMessage());

					result.addError(error);

					return "climaEditar";
				}
			}
		}
		if (action.equals("Cancelar")) {
			modelo.clear();

			return "redirect:/climaBuscar";
		}
		return "redirect:/";
	}
}
