package com.nixondinho;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;
import com.nixondinho.controller.ControladorMedicos;
import com.nixondinho.model.Medico;
import com.nixondinho.repo.RepoMedico;
import com.nixondinho.services.MedicoService;

@SpringBootTest
class Comprobacion {

	static Medico medico1, medicoRetornado, medico2;

	@Autowired
	private RepoMedico repoMedico;

	@BeforeAll
	public static void inicializandMedico() {

		medico1 = new Medico("steven", "andrade", "19", "cedula", "34343", (float) 10, "cardiologo", "6", "18");
	}

	@AfterAll
	public static void FormateandoMedico() {

		medico1 = null;
		medicoRetornado = null;
	}

	@Test
	void insercionMedico() throws Exception {

		// medicoRetornado = repoMedico.findById(medico1.getIdentificacion()).get();
		medicoRetornado = repoMedico.save(medico1);

		assertTrue(medico1.equals(medicoRetornado));
	}

	@Test
	void comparacionFallida() throws Exception {

		medicoRetornado = new Medico();

		assertFalse(medico1.equals(medicoRetornado));
	}

	@Test
	void insercionNula() throws Exception {
		assertThrows(org.springframework.dao.InvalidDataAccessApiUsageException.class, () -> {
			repoMedico.save(medico2);
		});

	}

	@Test
	void modificarMedico() throws Exception {

		medicoRetornado = repoMedico.findById("11").get();
		medicoRetornado.setNombre("ronaldinho");
		repoMedico.save(medicoRetornado);

		assertTrue(repoMedico.findById("11").get().getNombre().equalsIgnoreCase(medicoRetornado.getNombre()));
	}

	@Test
	void borrarMedico() throws Exception {

		assertThrows(Exception.class, () -> {

			repoMedico.deleteById(repoMedico.findById("27278").get().getIdentificacion());
		});

	}

}
