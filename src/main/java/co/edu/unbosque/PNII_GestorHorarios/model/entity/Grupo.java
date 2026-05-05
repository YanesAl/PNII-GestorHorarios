package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoGrupo;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grupos")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = {"estudiantes","seccion"})
@EqualsAndHashCode(exclude = {"estudiantes","seccion"})
public class Grupo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrupo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoGrupo estadoGrupo;

    @ManyToOne
    @JoinColumn(name = "id_seccion")
    private Seccion seccion;

    @ManyToMany
    @JoinTable(name = "grupo_estudiante",
               joinColumns = @JoinColumn(name = "id_grupo"),
               inverseJoinColumns = @JoinColumn(name = "id_estudiante"))
    @Builder.Default
    private List<Estudiante> estudiantes = new ArrayList<>();

    public void cerrarGrupo() { this.estadoGrupo = EstadoGrupo.CERRADO; }
    public void abrirGrupo()  { this.estadoGrupo = EstadoGrupo.ABIERTO; }

    public boolean adicionarEstudiante(Estudiante estudiante) {
        if (!EstadoGrupo.ABIERTO.equals(estadoGrupo)) return false;
        if (seccion != null && estudiantes.size() >= seccion.getCupoMaximo()) return false;
        return estudiantes.add(estudiante);
    }

    public boolean removerEstudiante(Estudiante estudiante) {
        return estudiantes.remove(estudiante);
    }
}
