package com.nixondinho;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.nixondinho.model.Medico;
import com.nixondinho.repo.RepoMedico;

@SpringBootTest
class Ejecucion {

	@Autowired
	private RepoMedico repoMedico;

	@Test
	@Sql(scripts = "/insertarMedicos.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	void insersionRegistrosMedicos() {
		List<Medico> medicos = repoMedico.findAll();

		assertTrue((medicos.size() == 6));

	}

}
