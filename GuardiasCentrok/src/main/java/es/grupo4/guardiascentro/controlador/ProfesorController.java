package es.grupo4.guardiascentro.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.grupo4.guardiascentro.modelo.Horario;
import es.grupo4.guardiascentro.modelo.HorarioRepositorio;
import es.grupo4.guardiascentro.modelo.Profesor;
import es.grupo4.guardiascentro.modelo.ProfesorRepositorio;
import es.grupo4.guardiascentro.modelo.ProfesorTienePerfil;
import es.grupo4.guardiascentro.modelo.ProfesorTienePerfilRepositorio;


@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {	
	@Autowired
     private final ProfesorRepositorio profesorRepositorio;
	 
	
	public ProfesorController(ProfesorRepositorio profesorRepositorio) {
	this.profesorRepositorio = profesorRepositorio;
 }
/**
 * Método para obtener una lista de profesores de la API
 * @return
 */

	@GetMapping("/listar")
	public ResponseEntity<?> obtenerListaProfesores()
	{
		List<Profesor> profesores = profesorRepositorio.findAll();
		if(profesores.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista de profesores esta vacía."); 
		return ResponseEntity.ok(profesores);
	}
	/**
	 * Método para obtener un profesor por id de la API
	 * @param id
	 * @return
	 */
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Integer id)
	{
		Profesor profesor=profesorRepositorio.findById(id).orElse(null);
		if(profesor==null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Profesor no encontrado."); 
		return ResponseEntity.ok(profesor);
	}
	
	/**
	 * Método para hacer el login: recoge la pwd introducida y comprueba si coincide con la base de datos
	 * @param pwd
	 * @param id
	 * @return
	 */	
	@PostMapping("/login/{user}")
	public ResponseEntity<?> login(@RequestParam String user, @RequestParam String pwd)
	{
		Profesor profesor=profesorRepositorio.findByUser(user).orElse(null);
		if(profesor!=null) {	
			if(profesor.getPassword().equals(pwd)) {
				return ResponseEntity.ok(profesor);
			}		
		}
			
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario o contraseña no son correctos.");
		  		
	}

	
	/**
	 * Método para crear un profesor
	 * @param nuevo
	 * @return
	 */
	@PostMapping("/crear")
	public Profesor nuevoProfesor(@RequestBody Profesor nuevo) {
		return profesorRepositorio.save(nuevo);
	}
	/**
	 * Crear un profesor devolviendo booleano
	 * @param nuevo
	 * @return
	 */
	
	@PostMapping("/bool")
	public boolean nuevoProfesorBool(@RequestBody Profesor nuevo) {
		Profesor profesor=profesorRepositorio.save(nuevo);
		if(profesor!=null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Método para actualizar un profesor por cualquier campo
	 * @param editar
	 * @param id
	 * @return
	 */
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> actualizarProfesor(@RequestBody Profesor editar,
	@PathVariable Integer id)
	{	
	Profesor profesor = profesorRepositorio.findById(id).orElse(null);
	if(profesor!=null) {
	profesor.setActivo(editar.getActivo());
	profesor.setApe1(editar.getApe1());
	profesor.setApe2(editar.getApe2());
	profesor.setBaja(editar.getBaja());
	profesor.setDeptCod(editar.getDeptCod());
	profesor.setDni(editar.getDni());
	profesor.setIdSustituye(editar.getIdSustituye());
	profesor.setNombre(editar.getNombre());
	profesor.setPassword(editar.getPassword());
	profesor.setTfno(editar.getTfno());
	profesor.setUser(editar.getUser());
	return ResponseEntity.ok(profesorRepositorio.save(profesor));
	}
	return ResponseEntity.notFound().build();	
	}
	
/**
 * Método para borrar un profesor
 * @param id
 * @return
 */
	
	@DeleteMapping("/borrar/{id}")
	public Profesor borrarProfesor(@PathVariable Integer id) {
			
		if(profesorRepositorio.existsById(id))
		{
		    Optional<Profesor> profesor = profesorRepositorio.findById(id);
			if (profesor.isPresent()) {
			   profesorRepositorio.delete(profesor.get());
			    return profesor.get();
			}
			
		}
		return null;
	}

  /**
   * Método para cambiar el id del profesor al que sustitye o ponerlo a null.
   * @param id
   * @param idSustitucion
   * @return
   */
	@PutMapping("/setSustitucion/{id}")
	@Transactional
	public ResponseEntity<?> setIdSustitucion(@PathVariable Integer id,@RequestParam Integer idSustitucion) { 
		Profesor profesor=profesorRepositorio.findById(id).orElse(null);
		if(profesor!=null) {
			profesor.setIdSustituye(idSustitucion);
			return ResponseEntity.ok(profesorRepositorio.save(profesor));
		}
		
		return ResponseEntity.notFound().build();
	}
	

	
}

