package es.grupo4.guardiascentro.modelo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfesorRepositorio extends JpaRepository<Profesor,Integer>{

	Optional<Profesor> findByUser(String user); 
	
	@Query(value="SELECT p FROM Profesor p WHERE p.user=:user")
	public Profesor getProfesorUser(@Param("user") String user);
	
	
	@Modifying
	@Query(value="UPDATE Profesor SET idSustituye=:idSustitucion WHERE id=:id")
	void setIdSustituye(@Param("id") Integer id, @Param("idSustitucion") Integer idSustitucion);
	
}
