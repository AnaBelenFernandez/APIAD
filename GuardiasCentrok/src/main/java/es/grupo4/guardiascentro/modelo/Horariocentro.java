package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the horariocentro database table.
 * 
 */
@Entity
@Table(name = "horariocentro")
@NamedQuery(name="Horariocentro.findAll", query="SELECT h FROM Horariocentro h")
public class Horariocentro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name="horafin")
	private Time horafin;

	@Column(name="horainicio")
	private Time horainicio;

	@Enumerated(EnumType.STRING)
	@Column(name="turno")
	private Turno turno;

	public Horariocentro() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Time getHorafin() {
		return horafin;
	}

	public void setHorafin(Time horafin) {
		this.horafin = horafin;
	}

	public Time getHorainicio() {
		return horainicio;
	}

	public void setHorainicio(Time horainicio) {
		this.horainicio = horainicio;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
}