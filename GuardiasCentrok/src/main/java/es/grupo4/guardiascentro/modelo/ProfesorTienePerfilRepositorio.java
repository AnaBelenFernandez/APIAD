package es.grupo4.guardiascentro.modelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfesorTienePerfilRepositorio extends JpaRepository<ProfesorTienePerfil,Integer>{

	@Query(value="SELECT p FROM ProfesorTienePerfil p WHERE p.profesor=:id")
	public ProfesorTienePerfil getInfo(@Param("id") Integer id);
}
