package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@Table(name="horario")
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="aula")
	private String aula;

	@Column(name="dia_semana")
	private Integer diaSemana;

	@Column(name="genera_guardia")
	private Byte generaGuardia;

	@Column(name="grupo")
	private String grupo;

	@Column(name="materia")
	private String materia;

	@Column(name="hora")
	private Integer hora;

    @Column(name="profesor")
	private Integer profesor;

	public Horario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Byte getGeneraGuardia() {
		return generaGuardia;
	}

	public void setGeneraGuardia(Byte generaGuardia) {
		this.generaGuardia = generaGuardia;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getProfesor() {
		return profesor;
	}

	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}

}