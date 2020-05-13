package com.nixondinho;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.mysql.jdbc.log.Log;
import com.mysql.jdbc.log.LogFactory;
import com.nixondinho.model.Medico;
import com.nixondinho.repo.RepoMedico;
import com.nixondinho.services.MedicoService;

@SpringBootTest
class Preparacion {

	@Autowired
	private RepoMedico repoMedico;

	@Test
	@Sql(scripts = "/formatearTablaMedicos.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	void validarPreparacion() {
		List<Medico> medicos = repoMedico.findAll();

		assertTrue(medicos.size() == 0);

	}

	

}
