package com.nixondinho.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "medicos")
@XmlRootElement
public class Medico {

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 40, message = " rango valido: 1 a 40 caracteres")

	@Column(name = "Nombre_Completo")
	private String nombre;

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 40, message = " rango valido: 1 a 40 caracteres")
	@Column(name = "apellidos")
	private String apellido;

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 40, message = "rango valido: 1 a 40 caracteres")

	@Id
	@Column(name = "Identificacion")
	private String identificacion;

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 20, message = "rango valido: 1 a 20 caracteres")

	@Column(name = "Tipo_Identificacion")
	private String tipoIdentificacion;

	@NotNull(message = "campo requerido")
	@Size(min = 1, max = 20, message = "rango valido: 1 a 20 caracteres")

	@Column(name = "Numero_Tarjeta_Profesional")
	private String numeroTarjetaProfesional;

	@NotNull(message = "campo requerido")
	@Min(value = 1, message = "ingrese experiencias mayore a 1 año")
	@Max(value = 70, message = "ingrese experiencias menores a 71 año")

	@Column(name = "Tiempo_Experiencia")
	private Float tiempoExperiencia;

	@NotNull(message = "campo requerido")

	@Column(name = "Especialidad")
	private String especialidad;

	@NotNull(message = "campo requerido")
	@Min(value = 6, message = "ingrese horario mayor a las 5 horas")
	@Max(value = 19, message = "ingrese horario menor a las  20 horas")

	@Column(name = "Hora_Inicio_Atencion")
	private String inicioAtencion;

	@NotNull(message = "campo requerido")
	@Min(value = 6, message = "ingrese horario mayor a las 5 horas")
	@Max(value = 19, message = "ingrese horario menor a las  20 horas")

	@Column(name = "Hora_Fin_Atencion")
	private String finAtencion;

	public Medico() {
	}

	public Medico(String nombre, String apellido, String identificacion, String tipoIdentificacion,
			String numeroTarjetaProfesional, Float tiempoExperiencia, String especialidad, String inicioAtencion,
			String finAtencion) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.identificacion = identificacion;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroTarjetaProfesional = numeroTarjetaProfesional;
		this.tiempoExperiencia = tiempoExperiencia;
		this.especialidad = especialidad;
		this.inicioAtencion = inicioAtencion;
		this.finAtencion = finAtencion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getNumeroTarjetaProfesional() {
		return numeroTarjetaProfesional;
	}

	public void setNumeroTarjetaProfesional(String numeroTarjetaProfesional) {
		this.numeroTarjetaProfesional = numeroTarjetaProfesional;
	}

	public Float getTiempoExperiencia() {
		return tiempoExperiencia;
	}

	public void setTiempoExperiencia(Float tiempoExperiencia) {
		this.tiempoExperiencia = tiempoExperiencia;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getInicioAtencion() {
		return inicioAtencion;
	}

	public void setInicioAtencion(String inicioAtencion) {
		this.inicioAtencion = inicioAtencion;
	}

	public String getFinAtencion() {
		return finAtencion;
	}

	public void setFinAtencion(String finAtencion) {
		this.finAtencion = finAtencion;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (especialidad == null) {
			if (other.especialidad != null)
				return false;
		} else if (!especialidad.equals(other.especialidad))
			return false;
		if (finAtencion == null) {
			if (other.finAtencion != null)
				return false;
		} else if (!finAtencion.equals(other.finAtencion))
			return false;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		if (inicioAtencion == null) {
			if (other.inicioAtencion != null)
				return false;
		} else if (!inicioAtencion.equals(other.inicioAtencion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroTarjetaProfesional == null) {
			if (other.numeroTarjetaProfesional != null)
				return false;
		} else if (!numeroTarjetaProfesional.equals(other.numeroTarjetaProfesional))
			return false;
		if (tiempoExperiencia == null) {
			if (other.tiempoExperiencia != null)
				return false;
		} else if (!tiempoExperiencia.equals(other.tiempoExperiencia))
			return false;
		if (tipoIdentificacion == null) {
			if (other.tipoIdentificacion != null)
				return false;
		} else if (!tipoIdentificacion.equals(other.tipoIdentificacion))
			return false;
		return true;
	}

	
}
