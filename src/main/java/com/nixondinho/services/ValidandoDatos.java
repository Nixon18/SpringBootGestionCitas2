package com.nixondinho.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.nixondinho.model.*;

@Service
public class ValidandoDatos {

	@Autowired
	MedicoService medicoService;

	@Autowired
	PacienteService pacienteService;

	@Autowired
	CitaService citaService;

	private int horaInicial, horaFinal, horarioCita;
	private Cita disponibilidadPaciente, disponibilidadMedico;
	private boolean rangoCita;

	public ResponseEntity<String> validarRegistro(Cita citaInsertar) throws Exception {

		if (pacienteService.obtenerPorId(citaInsertar.getPaciente()) == null) {

			return new ResponseEntity<>("el paciente asignado no existe", HttpStatus.BAD_REQUEST);

		} else if (medicoService.obtenerPorId(citaInsertar.getMedico()) == null) {

			return new ResponseEntity<>("el medico asignado no existe", HttpStatus.BAD_REQUEST);
		}

		else {

			boolean obtenerDatosCita = ObtenerDatosCita(citaInsertar);

			if (!obtenerDatosCita) {

				return new ResponseEntity<>("ingrese un tipo de dato numerico.", HttpStatus.BAD_REQUEST);

			} else {

				if (rangoCita) {

					return new ResponseEntity<>("Valide el horario del medico asignado", HttpStatus.BAD_REQUEST);

				} else {

					if ((disponibilidadPaciente != null) || (disponibilidadMedico != null)) {

						return new ResponseEntity<>("la hora solicitada ya esta agendada con ese medico o paciente",
								HttpStatus.BAD_REQUEST);

					} else {

						citaService.crear(citaInsertar);

						return new ResponseEntity<>("datos insertados correctamente.", HttpStatus.OK);

					}

				}

			}

		}

	}

	public boolean ObtenerDatosCita(Cita citaInsertar) {

		horaInicial = Integer.parseInt(medicoService.obtenerPorId(citaInsertar.getMedico()).getInicioAtencion());
		horaFinal = Integer.parseInt(medicoService.obtenerPorId(citaInsertar.getMedico()).getFinAtencion());

		disponibilidadPaciente = citaService.obtenerPorHorarioCitaYPaciente(citaInsertar.getHorarioCita(),
				citaInsertar.getPaciente());
		disponibilidadMedico = citaService.obtenerPorHorarioCitaYMedico(citaInsertar.getHorarioCita(),
				citaInsertar.getMedico());
		try {
			horarioCita = Integer.parseInt(citaInsertar.getHorarioCita());
			rangoCita = (horarioCita < horaInicial) || (horarioCita > horaFinal);

			return true;

		} catch (Exception e) {
			return false;
		}

	}

}
