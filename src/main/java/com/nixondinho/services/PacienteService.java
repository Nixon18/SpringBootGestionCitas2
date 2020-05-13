package com.nixondinho.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nixondinho.model.Paciente;
import com.nixondinho.repo.RepoPaciente;

@Service
public class PacienteService {

	@Autowired
	private RepoPaciente repoPaciente;

	public PacienteService() {
	}

	public void crear(Paciente paciente) {

		repoPaciente.save(paciente);

	}

	public void actualizar(Paciente paciente) {

		repoPaciente.save(paciente);

	}

	public boolean borrar(String id) {

		try {
			repoPaciente.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Paciente> obtener() {

		return repoPaciente.findAll();

	}

	public Paciente obtenerPorId(String id) {
		try {
			return repoPaciente.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}

	}

	public List<Paciente> obtenerPorPaginacion(Pageable pageable) {

		return repoPaciente.findAll(pageable).getContent();

	}

}
