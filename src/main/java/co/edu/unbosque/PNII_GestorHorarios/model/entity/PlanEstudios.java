package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "planes_estudio")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
@ToString(exclude = "area")
@EqualsAndHashCode(exclude = "area")
public class PlanEstudios {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlanEstudios;

    @Column(nullable = false, length = 150)
    private String nombrePlanEstudios;

    @Column(nullable = false, unique = true, length = 20)
    private String codigoPlanEstudios;

    @Column(nullable = false)
    private Integer numeroCreditosTotal;

    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "plan_curso",
               joinColumns = @JoinColumn(name = "id_plan"),
               inverseJoinColumns = @JoinColumn(name = "id_curso"))
    @Builder.Default
    private List<Curso> cursos = new ArrayList<>();

    public void agregarCurso(Curso curso)    { cursos.add(curso); }
    public void removerCurso(Curso curso)    { cursos.remove(curso); }
    public List<Curso> obtenerCursos()       { return cursos; }
    public boolean tieneCurso(Curso curso)   { return cursos.contains(curso); }
}
