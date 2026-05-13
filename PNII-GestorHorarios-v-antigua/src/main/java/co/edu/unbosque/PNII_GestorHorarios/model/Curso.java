package co.edu.unbosque.PNII_GestorHorarios.model;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.TipoAula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;

    private String nombreCurso;
    private int intensidadHoraria;
    private int semestre;
    private int creditos;

    // Preguntar si se conecta entonces Curso con el enum
    // esto es porque el tipo de aula aqui tiene un proposito distinto al de
    // Aula porque aqui dice que tipo de aula es requerida en el curso, usa el mismo
    // enum
    @Enumerated(EnumType.STRING)
    private TipoAula aulaRequerida;

    @ManyToOne
    @JoinColumn(name = "id_plan_estudios")
    private PlanEstudios planEstudios;

    @ManyToMany
    @JoinTable(name = "curso_prerrequisito", joinColumns = @JoinColumn(name = "id_curso"), inverseJoinColumns = @JoinColumn(name = "id_prerrequisito"))
    private List<Curso> prerrequisitos = new ArrayList<>();

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grupo> grupos = new ArrayList<>();

    public Boolean requiereAulaEspecial() {
        return aulaRequerida != null && aulaRequerida != TipoAula.GRUPAL;
    }

    public Boolean tienePrerrequisitos() {
        return prerrequisitos != null && !prerrequisitos.isEmpty();
    }
}