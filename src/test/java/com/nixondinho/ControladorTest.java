package com.nixondinho;

import static org.junit.jupiter.api.Assertions.*;

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
import com.nixondinho.repo.RepoMedico;
import com.nixondinho.services.MedicoService;

@SpringBootTest
class ControladorTest {

//	@Autowired
	private RepoMedico repoMedico;

	@Autowired
	MedicoService medicoService;

	@BeforeAll
	public static void datos() {

		System.out.println("hola que mas");
	}

	@Test
	@Sql(scripts = "/eliminando.sql", executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
	// @Sql("eliminando.sql")
	void datos1() {

		int resultado = 1 + 2;
		int esperado = 3;

		assertTrue(resultado == esperado);

	}

	@Test
	void datos2() {

		// medicoService = new MedicoService();
		System.out.println(medicoService.borrar("27278"));

		int resultado = 1 + 3;
		int esperado = 5;

		assertTrue(resultado != esperado);
	}

}
