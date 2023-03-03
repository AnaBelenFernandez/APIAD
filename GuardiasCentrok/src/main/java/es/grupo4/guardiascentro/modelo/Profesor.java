package es.grupo4.guardiascentro.modelo;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.ColumnTransformer;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;


/**
 * The persistent class for the profesores database table.
 * 
 */
@Entity
@Table(name="profesores")
@NamedQuery(name="Profesor.findAll", query="SELECT p FROM Profesor p")
public class Profesor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="activo")
	private Byte activo;

	@Column(name="ape1")
	private String ape1;

	@Column(name="ape2")
	private String ape2;

	@Column(name="baja")
	private Byte baja;

	@Column(name="dept_cod")
	private String deptCod;

	@Column(name="dni")
	private String dni;

	@Column(name="id_sustituye")
	private Integer idSustituye;

	@Column(name="nombre")
	private String nombre;

	@Column(name="password")
	private String password;

	@Column(name="tfno")
	private String tfno;

	@Column(name="user")
	private String user;

	public Profesor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Byte getActivo() {
		return activo;
	}

	public void setActivo(Byte activo) {
		this.activo = activo;
	}

	public String getApe1() {
		return ape1;
	}

	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}

	public String getApe2() {
		return ape2;
	}

	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}

	public Byte getBaja() {
		return baja;
	}

	public void setBaja(Byte baja) {
		this.baja = baja;
	}

	public String getDeptCod() {
		return deptCod;
	}

	public void setDeptCod(String deptCod) {
		this.deptCod = deptCod;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Integer getIdSustituye() {
		return idSustituye;
	}

	public void setIdSustituye(Integer idSustituye) {
		this.idSustituye = idSustituye;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTfno() {
		return tfno;
	}

	public void setTfno(String tfno) {
		this.tfno = tfno;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}