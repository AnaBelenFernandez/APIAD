package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;


/**
 * The persistent class for the perfiles database table.
 * 
 */
@Entity
@Table(name="perfiles")
@NamedQuery(name="Perfil.findAll", query="SELECT p FROM Perfil p")
public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idperfil;

	@Column(name="nom_perfil")
	private String nomPerfil;


	public Perfil() {
	}


	public Integer getIdperfil() {
		return idperfil;
	}


	public void setIdperfil(Integer idperfil) {
		this.idperfil = idperfil;
	}


	public String getNomPerfil() {
		return nomPerfil;
	}


	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
	}



}