package co.edu.unbosque.PNII_GestorHorarios.repository;

import co.edu.unbosque.PNII_GestorHorarios.model.entity.Docente;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoDocente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Integer> {
    List<Docente> findByEstadoDocente(EstadoDocente estado);
    Optional<Docente> findByCorreo(String correo);
}
