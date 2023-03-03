package es.grupo4.guardiascentro.controlador;

import es.grupo4.guardiascentro.modelo.Estado;
import es.grupo4.guardiascentro.modelo.Guardia;
import es.grupo4.guardiascentro.modelo.GuardiaRepositorio;
import es.grupo4.guardiascentro.modelo.Horario;
import es.grupo4.guardiascentro.modelo.HorarioRepositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.grupo4.*;


@RestController
@RequestMapping("/api/guardias")
public class GuardiaController {
	@Autowired
	private final GuardiaRepositorio guardiaRepositorio;

	public GuardiaController(GuardiaRepositorio guardiaRepositorio) {
		this.guardiaRepositorio = guardiaRepositorio;
	}

	/**
	 * Método para obtener la lista de guardias de la api
	 * @return
	 */
		@GetMapping("/listar")
	public ResponseEntity<?> obtenerGuardias()
	{
	List<Guardia> guardias = guardiaRepositorio.findAll();
	if(guardias.isEmpty())
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista de horarios esta vacía."); 
	return ResponseEntity.ok(guardias);
	}

	/**
	 * Método para obtener una guardia a partir del id
	 * @param id
	 * @return
	 */
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> obtenerGuardiaId(@PathVariable Integer id)
	{
	Guardia guardia = guardiaRepositorio.findById(id).orElse(null);
	if(guardia==null)
	return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Guardia no encontrada."); 
	return ResponseEntity.ok(guardia);
	}
	
	

/**
 * Método para crear una guardia
 * @param nueva
 * @return
 */
	
	@PostMapping("/crear")
	public ResponseEntity<Guardia> nuevaGuardia(@RequestBody Guardia nueva)
	{
	Guardia guardada = guardiaRepositorio.save(nueva);
	return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
	}

/**
 * Método para actualizar Guardia por cualquier campo, hay que pasarle el objeto
 * @param editar
 * @param id
 * @param profesor
 * @return
 */
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> actualizarGuardia(@RequestBody Guardia editar,
	@PathVariable Integer id)
	{
	Guardia guardia = guardiaRepositorio.findById(id).orElse(null);
	if(guardia!=null) {
		guardia.setProfesorFalta(editar.getProfesorFalta());
		guardia.setHorario(editar.getHorario());
		guardia.setDiaSemana(editar.getDiaSemana());
		guardia.setHora(editar.getHora());
		guardia.setAviso(editar.getAviso());	
		guardia.setProfesorGuardia(editar.getProfesorGuardia());
		guardia.setEstado(editar.getEstado());
		guardia.setFecha(editar.getFecha());
		guardia.setGrupo(editar.getGrupo());
		guardia.setAula(editar.getAula());
		guardia.setObservaciones(editar.getObservaciones());
		return ResponseEntity.ok(guardiaRepositorio.save(guardia));
	}
	return ResponseEntity.notFound().build();
	}
	/**
	 * Método para borrar una guardia
	 * @param id
	 * @return
	 */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarGuardia(@PathVariable Integer id)
	{
	guardiaRepositorio.deleteById(id);
	return ResponseEntity.noContent().build();
	}

	/**
	 * Método que saca el listado de guardias sin sustitución
	 * @return 
	 */
	@GetMapping("/listarPosiblesGuardias")
	public ResponseEntity<?> obtenerGuardiasSinSustitucion()
	{
	List<Guardia> guardias = guardiaRepositorio.getGuardiasSinCubrir();
	if(guardias.isEmpty())
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sin guardias sin cubrir");
	return ResponseEntity.ok(guardias);
	}
	
	/**
	 * Método para hacer un set al estado de la guardia
	 * @param id
	 * @param estado
	 * @return
	 */
	@PutMapping("/setEstado/{id}")
	@Transactional
	public ResponseEntity<?> setGuardiaEstado(@PathVariable Integer id,@RequestParam Estado estado) { 
		Guardia guardia=guardiaRepositorio.findById(id).orElse(null);
		if(guardia!=null) {
			guardia.setEstado(estado);
		    guardiaRepositorio.save(guardia);
			return ResponseEntity.ok(guardia);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	/**
	 * Método que devuelve el listado de todas las guardias de un profesor.
	 * @param id
	 */
	@GetMapping("/getAllGuardias/{profesor1_.id}")
	public ResponseEntity<?> obtenerGuardiasProfesor(@RequestParam Integer id){
		List<Guardia> guardias=guardiaRepositorio.findAll().stream().filter(g->g.getProfesorFalta()==id).toList();
		if(guardias.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado guardias asociadas al profesor."); 
		return ResponseEntity.ok(guardias);
	}
}