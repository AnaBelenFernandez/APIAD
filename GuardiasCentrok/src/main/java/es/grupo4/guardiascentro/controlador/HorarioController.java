package es.grupo4.guardiascentro.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import es.grupo4.guardiascentro.modelo.Horario;
import es.grupo4.guardiascentro.modelo.HorarioRepositorio;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
@Autowired
private final HorarioRepositorio horarioRepositorio;

public HorarioController(HorarioRepositorio horarioRepositorio) {
	this.horarioRepositorio = horarioRepositorio;
}

/**
 * Método que devuelve la lista de todos los horarios
 */
@GetMapping("/devuelveTodos")
public ResponseEntity<?> getAll(){
	List<Horario> horarios=horarioRepositorio.findAll();
	if(horarios.isEmpty())
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista de horarios esta vacía."); 
	return ResponseEntity.ok(horarios);
}

/**
 * Método que devuelve un horario por profesor y día de la semana.
 * @param profesorId
 * @param diaSemana
 * @return
 */
@GetMapping("/{profesor0_.id}/{diaSemana}/")
public ResponseEntity<?> getHorarios(@RequestParam(name = "profesor id") Integer profesorId,@RequestParam(name = "diaSemana") Integer diaSemana) {
	List<Horario> horarios=horarioRepositorio
			.findAll()
			.stream()
			.filter(x->x.getProfesor()==profesorId && x.getDiaSemana()==diaSemana)
			.toList();
	
	if(horarios.isEmpty()) 
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado horarios en el día especificado."); 
	
	return ResponseEntity.ok(horarios);	

}

/**
 * Método que devuelve todos los horarios del profesor.
 * @param id
 * @return
 */
@GetMapping("/getTodosProfesor/{profesor0_.id}")
public ResponseEntity<?> obtenerHorariosProfesor(@RequestParam Integer id){
	List<Horario> horarios=horarioRepositorio.findAll().stream().filter(h->h.getProfesor()==id).toList();
	if(horarios.isEmpty())
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista de horarios del profesor esta vacía."); 
	return ResponseEntity.ok(horarios);
}

/**
 *  Método que modifica el campo de genera guardia
 * @param id
 * @param genera
 * @return
 */
@PutMapping("/setGeneraGuardia/{id}")
@Transactional
public ResponseEntity<?> setIdSustitucion(@PathVariable Integer id,@RequestParam Byte genera) { 
	Horario horario=horarioRepositorio.findById(id).orElse(null);
	if(horario!=null) {
		horario.setGeneraGuardia(genera);
		return ResponseEntity.ok(horarioRepositorio.save(horario));
	}
	
	return ResponseEntity.notFound().build();
}

}
