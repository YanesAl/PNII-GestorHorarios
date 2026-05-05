package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.AulaRequerida;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cursos")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Curso {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;

    @Column(nullable = false, length = 150)
    private String nombreCurso;

    @Column(nullable = false)
    private Integer intensidadHoraria;   // horas semanales

    @Column(nullable = false)
    private Integer semestre;

    @Column(nullable = false)
    private Integer creditos;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AulaRequerida aulaRequerida;

    @ManyToMany
    @JoinTable(name = "curso_prerrequisito",
               joinColumns = @JoinColumn(name = "id_curso"),
               inverseJoinColumns = @JoinColumn(name = "id_prerrequisito"))
    @Builder.Default
    private List<Curso> prerrequisitos = new ArrayList<>();

    public boolean requiereAulaEspecial() {
        return aulaRequerida != null && !AulaRequerida.NINGUNA.equals(aulaRequerida);
    }

    public boolean tienePrerrequisitos() {
        return !prerrequisitos.isEmpty();
    }
}
