package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the avisos_guardia database table.
 * 
 */
@Entity
@Table(name="avisos_guardia")
@NamedQuery(name="AvisosGuardia.findAll", query="SELECT a FROM AvisosGuardia a")
public class AvisosGuardia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aviso")
	private int idAviso;
	
	@Column(name = "anulado", nullable=true)
	private Byte anulado;

	@Column(name = "confirmado",nullable=true)
	private Byte confirmado;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_guardia",nullable=true)
	private Date fechaGuardia;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_hora_aviso",nullable=true)
	private Date fechaHoraAviso;

	@Column(name = "motivo",nullable=true)
	private String motivo;

	@Column(name = "observaciones",nullable=true)
	@Lob
	private String observaciones;

	@Column(name="horario",nullable=false)
	private Integer horario;

	@Column(name="profesor",nullable=false)
	private Integer profesor;

	public AvisosGuardia() {
	}

	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public int getIdAviso() {
		return idAviso;
	}

	public Byte getAnulado() {
		return anulado;
	}

	public void setAnulado(Byte anulado) {
		this.anulado = anulado;
	}

	public Byte getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(Byte confirmado) {
		this.confirmado = confirmado;
	}

	public Date getFechaGuardia() {
		return fechaGuardia;
	}

	public void setFechaGuardia(Date fechaGuardia) {
		this.fechaGuardia = fechaGuardia;
	}

	public Date getFechaHoraAviso() {
		return fechaHoraAviso;
	}

	public void setFechaHoraAviso(Date fechaHoraAviso) {
		this.fechaHoraAviso = fechaHoraAviso;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getHorario() {
		return horario;
	}

	public void setHorario(Integer horario) {
		this.horario = horario;
	}

	public Integer getProfesor() {
		return profesor;
	}

	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}

	
}