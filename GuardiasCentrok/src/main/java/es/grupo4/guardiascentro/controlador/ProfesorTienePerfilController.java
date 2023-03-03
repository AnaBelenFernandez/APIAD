package es.grupo4.guardiascentro.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.grupo4.guardiascentro.modelo.Profesor;
import es.grupo4.guardiascentro.modelo.ProfesorTienePerfil;
import es.grupo4.guardiascentro.modelo.ProfesorTienePerfilRepositorio;


@RestController
@RequestMapping("/api/profesorTienePerfil")
public class ProfesorTienePerfilController {
	@Autowired
    private final ProfesorTienePerfilRepositorio profesorTienePerfilRepositorio;

	public ProfesorTienePerfilController(ProfesorTienePerfilRepositorio profesorTienePerfilRepositorio) {
		super();
		this.profesorTienePerfilRepositorio = profesorTienePerfilRepositorio;
	}
	
	/**
	 * Metodo que devuelve el perfil de un usuario, si es mayor de 2 pertecene a administración o dirección, se usa junto con el login.
	 * @param id
	 * @return
	 */

	@GetMapping("/buscarPerfil/{profesor}")
	public ResponseEntity<?> obtenerPerfil(@RequestParam Integer id)
	{
		ProfesorTienePerfil profesorTienePerfil=profesorTienePerfilRepositorio.getInfo(id);
		if(profesorTienePerfil!=null) {
			if(profesorTienePerfil.getPerfil()>2)
				return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El perfil no pertenece a dirección o administración");
	}
	
}
