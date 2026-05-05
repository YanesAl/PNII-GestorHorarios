package co.edu.unbosque.PNII_GestorHorarios.repository;

import co.edu.unbosque.PNII_GestorHorarios.model.entity.Seccion;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoSeccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {
    Optional<Seccion> findByCodigo(String codigo);
    List<Seccion> findByEstadoSeccion(EstadoSeccion estado);

    @Query("SELECT s FROM Seccion s WHERE s.docente.idDocente = :idDocente")
    List<Seccion> findByDocenteId(Integer idDocente);

    @Query("SELECT s FROM Seccion s WHERE s.aula.idAula = :idAula")
    List<Seccion> findByAulaId(Integer idAula);

    @Query("SELECT s FROM Seccion s WHERE s.franja.idFranja = :idFranja")
    List<Seccion> findByFranjaId(Integer idFranja);
}
