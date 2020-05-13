package com.nixondinho.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nixondinho.model.Cita;
import com.nixondinho.services.CitaService;
import com.nixondinho.services.ValidandoDatos;

@RestController
@RequestMapping(path = "/citas")
public class ControladorCitas {

	@Autowired
	CitaService citaService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Cita>> listar(Pageable pageable) {

		return new ResponseEntity<>(citaService.obtenerPorPaginacion(pageable), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cita> listarProducto(@PathVariable("id") Integer id) {

		return new ResponseEntity<>(citaService.obtenerPorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> insertarRegistro(@RequestBody @Valid Cita cita) throws Exception {

		return validadorRegistros.validarRegistro(cita);
	}

}
