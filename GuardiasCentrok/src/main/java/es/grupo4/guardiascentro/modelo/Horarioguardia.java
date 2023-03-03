package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the horarioguardias database table.
 * 
 */
@Entity
@Table(name="horarioguardias")
@NamedQuery(name="Horarioguardia.findAll", query="SELECT h FROM Horarioguardia h")
public class Horarioguardia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="dia_semana")
	private Integer diaSemana;

	@Column(name="realizadas")
	private Integer realizadas;

	@Column(name="hora_guardia")
	private Integer horariocentro;

	@Column(name="profesor")
	private Integer profesor;

	public Horarioguardia() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Integer getRealizadas() {
		return realizadas;
	}

	public void setRealizadas(Integer realizadas) {
		this.realizadas = realizadas;
	}

	public Integer getHorariocentro() {
		return horariocentro;
	}

	public void setHorariocentro(Integer horariocentro) {
		this.horariocentro = horariocentro;
	}

	public Integer getProfesor() {
		return profesor;
	}

	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}

}