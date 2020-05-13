package com.nixondinho.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nixondinho.model.Paciente;
import com.nixondinho.services.*;

@RestController
@RequestMapping("/pacientes")
public class ControladorPacientes extends ControladorGeneral {

	@Autowired
	PacienteService pacienteService;

	@Autowired
	ValidandoDatos validadorRegistros;

	@GetMapping(produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Paciente>> listar(Pageable pageable) {

		return new ResponseEntity<>(pacienteService.obtenerPorPaginacion(pageable), HttpStatus.OK);

	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Paciente> listarProducto(@PathVariable("id") String id) throws Exception {

		return new ResponseEntity<>(pacienteService.obtenerPorId(id), HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> eliminarRegistro(@PathVariable("id") String id) {

		pacienteService.borrar(id);

		return new ResponseEntity<>("datos eliminados correctamente", HttpStatus.ACCEPTED);

	}

	@PutMapping
	public ResponseEntity<String> actualizarRegistro(@RequestBody @Valid Paciente pacienteActualizar) throws Exception {

		pacienteService.crear(pacienteActualizar);

		return new ResponseEntity<>("datos actualizados correctamente.", HttpStatus.CREATED);

	}

	@PostMapping
	public ResponseEntity<String> insertarRegistro(@RequestBody @Valid Paciente pacienteActualizar) throws Exception {

		pacienteService.crear(pacienteActualizar);

		return new ResponseEntity<>("datos insertados correctamente.", HttpStatus.CREATED);

	}

}
