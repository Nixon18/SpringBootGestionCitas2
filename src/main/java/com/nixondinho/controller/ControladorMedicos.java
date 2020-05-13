package com.nixondinho.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nixondinho.model.Medico;
import com.nixondinho.services.MedicoService;
import com.nixondinho.services.ValidandoDatos;

@RestController
@RequestMapping(path = "/medicos")
public class ControladorMedicos extends ControladorGeneral {

	@Autowired
	MedicoService medicoService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<Medico> cargarMedicos() {

		return medicoService.obtener();

	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public Medico cargarMedico(@PathVariable("id") String id) throws Exception {

		return medicoService.obtenerPorId(id);
	}

	@DeleteMapping(value = "/{id}")
	public boolean eliminarMedico(@PathVariable("id") String id) {

		return medicoService.borrar(id);

	}

	@PutMapping
	public String actualizarMedico(@RequestBody @Valid Medico medicoActualizar) throws Exception {

		medicoService.crear(medicoActualizar);
		return "datos actualizados correctamente.";

	}

	@PostMapping
	public String insertarMedico(@RequestBody @Valid Medico medicoActualizar) throws Exception {

		medicoService.crear(medicoActualizar);
		return "datos insertados correctamente.";

	}

}
