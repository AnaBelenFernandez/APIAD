package es.grupo4.guardiascentro.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GuardiaRepositorio extends JpaRepository<Guardia, Integer>{	
	Optional<Guardia> findById(Integer id);	
	
	@Query(value="SELECT g FROM Guardia g WHERE g.profesorGuardia IS NULL")
	public List<Guardia> getGuardiasSinCubrir();
	
}
