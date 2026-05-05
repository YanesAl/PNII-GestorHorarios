package co.edu.unbosque.PNII_GestorHorarios.repository;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
