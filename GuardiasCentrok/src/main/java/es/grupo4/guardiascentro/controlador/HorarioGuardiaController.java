package es.grupo4.guardiascentro.controlador;

import java.util.List;
import java.util.Optional;

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

import es.grupo4.guardiascentro.modelo.HorarioGuardiaRepositorio;
import es.grupo4.guardiascentro.modelo.Horarioguardia;
import es.grupo4.guardiascentro.modelo.Profesor;

@RestController
@RequestMapping("/api/horarioGuardia")
public class HorarioGuardiaController {
	@Autowired
	private final HorarioGuardiaRepositorio horarioGuardiaRepositorio;

	public HorarioGuardiaController(HorarioGuardiaRepositorio horarioGuardiaRepositorio) {
		this.horarioGuardiaRepositorio = horarioGuardiaRepositorio;
	}
	
	@GetMapping("/buscar/{profesor1_.id}")
	public ResponseEntity<?> obtenerUno(@RequestParam Integer id)
	{
		List<Horarioguardia> horarios=horarioGuardiaRepositorio.findAll().stream().filter(h->h.getProfesor()==id).toList();
		if(horarios.isEmpty())
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se han encontrado horarios de guardias asociadas al profesor."); 
		return ResponseEntity.ok(horarios);
	}
	
	/**
	 * Método que aumenta el número de guardia realizadas, por horario.
	 * @param id
	 * @return
	 */
	@PutMapping("/setRealizadas/{profesor1_.id}/{diaSemana}/{horariocentro1_.id}")
	@Transactional
	public ResponseEntity<?> setRealizadas(@RequestParam Integer profesorId, @RequestParam Integer diaSemana, @RequestParam Integer horario) { 
		
		Optional<Horarioguardia> horarioguardia=horarioGuardiaRepositorio.findAll().stream().filter(h-> h.getProfesor()==profesorId && h.getDiaSemana()==diaSemana && h.getHorariocentro()==horario).findFirst();	
		if(horarioguardia.isPresent()) {
			Horarioguardia h=horarioguardia.get();
			h.setRealizadas(h.getRealizadas()+1);
			return ResponseEntity.ok(horarioGuardiaRepositorio.save(h));		
		}
		return ResponseEntity.notFound().build();
	}
}
