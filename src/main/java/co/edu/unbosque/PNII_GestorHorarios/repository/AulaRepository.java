package co.edu.unbosque.PNII_GestorHorarios.repository;
import co.edu.unbosque.PNII_GestorHorarios.model.entity.Aula;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoAula;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.TipoAula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {
    List<Aula> findByEstadoAula(EstadoAula estado);
    List<Aula> findByTipoAulaAndEstadoAula(TipoAula tipo, EstadoAula estado);
    Optional<Aula> findByCodigoAula(String codigo);
}
