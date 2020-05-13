package com.nixondinho.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nixondinho.model.Medico;
import com.nixondinho.repo.RepoMedico;

@Service
public class MedicoService {

	@Autowired

	private RepoMedico repoMedico;

	public void crear(Medico medico) {

		repoMedico.save(medico);

	}

	public void actualizar(Medico medico) {

		repoMedico.save(medico);

	}

	public boolean borrar(String codigo) {

		try {
			repoMedico.deleteById(codigo);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public List<Medico> obtener() {

		return repoMedico.findAll();

	}

	public Medico obtenerPorId(String id) {

		try {
			return repoMedico.findById(id).get();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return null;
		}

	}

	public List<Medico> obtenerPorPaginacion(Pageable pageable) {

		return repoMedico.findAll(pageable).getContent();

	}

}
