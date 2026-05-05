package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoEstudiante;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiantes")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "grupos")
@EqualsAndHashCode(exclude = "grupos")
public class Estudiante {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;

    @Column(nullable = false, length = 100)
    private String nombreEstudiante;

    @Column(nullable = false, length = 100)
    private String apellidoEstudiante;

    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @Column(nullable = false)
    private Integer semestreCursa;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoEstudiante estadoEstudiante;

    @Column(nullable = false)
    private Integer creditosAprobados;

    @ManyToMany(mappedBy = "estudiantes")
    @Builder.Default
    private List<Grupo> grupos = new ArrayList<>();

    public void seleccionarGrupo(Grupo grupo) {
        if (!grupos.contains(grupo)) grupos.add(grupo);
    }

    public void quitarGrupo(Grupo grupo) {
        grupos.remove(grupo);
    }

    public boolean validarNoDuplicarCurso(Grupo grupo) {
        return grupos.stream()
            .noneMatch(g -> g.getSeccion() != null
                && grupo.getSeccion() != null
                && g.getSeccion().getCurso() != null
                && g.getSeccion().getCurso().equals(grupo.getSeccion().getCurso()));
    }

    public boolean tieneCurso(Curso curso) {
        return grupos.stream()
            .anyMatch(g -> g.getSeccion() != null
                && curso.equals(g.getSeccion().getCurso()));
    }

    public List<FranjaHoraria> verHorarioPropuesto() {
        return grupos.stream()
            .filter(g -> g.getSeccion() != null && g.getSeccion().getFranja() != null)
            .map(g -> g.getSeccion().getFranja())
            .toList();
    }

    public void confirmarInscripcion() {
        // hook para lógica futura de confirmación oficial
    }
}
