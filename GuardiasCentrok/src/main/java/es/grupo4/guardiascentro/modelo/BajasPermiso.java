package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;


/**
 * The persistent class for the bajas_permisos database table.
 * 
 */
@Entity
@Table(name="bajas_permisos")
@NamedQuery(name="BajasPermiso.findAll", query="SELECT b FROM BajasPermiso b")
public class BajasPermiso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idbaja;

	@Temporal(TemporalType.DATE)
	@Column(name="fechafin")
	private Date fechafin;

	@Temporal(TemporalType.DATE)
	@Column(name="fechainicio")
	private Date fechainicio;

	@Enumerated(EnumType.STRING)
	@Column(name="tipo", nullable=false)
	private Tipo tipo;

	@Column(name="profesor", nullable=false)
	private Integer profesor;

	public BajasPermiso() {
	}

	public int getIdbaja() {
		return idbaja;
	}

	public void setIdbaja(int idbaja) {
		this.idbaja = idbaja;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Integer getProfesor() {
		return profesor;
	}

	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}
}