package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the profesor_tiene_perfil database table.
 * 
 */
@Entity
@Table(name="profesor_tiene_perfil")
@NamedQuery(name="ProfesorTienePerfil.findAll", query="SELECT p FROM ProfesorTienePerfil p")
public class ProfesorTienePerfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="perfil")
	private Integer perfil;

	@Column(name="profesor")
	private Integer profesor;

	public ProfesorTienePerfil() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPerfil() {
		return perfil;
	}

	public void setPerfil(Integer perfil) {
		this.perfil = perfil;
	}

	public Integer getProfesor() {
		return profesor;
	}

	public void setProfesor(Integer profesor) {
		this.profesor = profesor;
	}


}