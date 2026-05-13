package co.edu.unbosque.PNII_GestorHorarios.model;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoGrupo;
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
@Table(name = "grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrupo;

    @Enumerated(EnumType.STRING)
    private EstadoGrupo estadoGrupo;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToMany
    @JoinTable(name = "grupo_estudiante", joinColumns = @JoinColumn(name = "id_grupo"), inverseJoinColumns = @JoinColumn(name = "id_estudiante"))
    private List<Estudiante> estudiantes = new ArrayList<>();

    public void cerrarGrupo() {
        this.estadoGrupo = EstadoGrupo.CERRADO;
    }

    public void abrirGrupo() {
        this.estadoGrupo = EstadoGrupo.ABIERTO;
    }

    public Boolean adicionarEstudiante(Estudiante estudiante) {
        if (estudiante == null || estudiantes.contains(estudiante)) {
            return false;
        }
        estudiantes.add(estudiante);
        return true;
    }

    public Boolean removerEstudiante(Estudiante estudiante) {
        if (estudiante == null || !estudiantes.contains(estudiante)) {
            return false;
        }
        estudiantes.remove(estudiante);
        return true;
    }
}
