package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;


/**
 * The persistent class for the guardias database table.
 * 
 */
@Entity
@Table(name="guardias")
@NamedQuery(name="Guardia.findAll", query="SELECT g FROM Guardia g")
public class Guardia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "prof_falta", nullable=false)
	private Integer profesorFalta;
	
	@Column(name = "prof_hace_guardia", nullable=true)
	private Integer profesorGuardia;
	
	@Enumerated(EnumType.STRING)
	@Column(name="estado")
	private Estado estado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date fecha;

	@Column(name = "horario", nullable=false)
	private Integer horario;
	
	@Column(name = "dia_semana", nullable=true)
	private Integer diaSemana;
	
	@Column(name = "hora", nullable=true)
	private String hora;
	
	@Column(name = "aviso", nullable=true)
	private Integer aviso;
	
	@Column(name = "grupo", nullable=true)
	private String grupo;
	
	@Column(name = "aula", nullable=true)
	private String aula;
	
	@Column(name = "observaciones", nullable=true)
	private String observaciones;

	public Guardia() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getProfesorFalta() {
		return profesorFalta;
	}

	public void setProfesorFalta(Integer profesorFalta) {
		this.profesorFalta = profesorFalta;
	}

	public Integer getProfesorGuardia() {
		return profesorGuardia;
	}

	public void setProfesorGuardia(Integer profesorGuardia) {
		this.profesorGuardia = profesorGuardia;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	public Integer getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(Integer diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getAviso() {
		return aviso;
	}

	public void setAviso(Integer aviso) {
		this.aviso = aviso;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}