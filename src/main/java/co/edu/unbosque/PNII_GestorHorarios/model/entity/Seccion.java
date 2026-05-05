package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoSeccion;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "secciones")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Seccion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeccion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoSeccion estadoSeccion;

    @Column(nullable = false, unique = true, length = 30)
    private String codigo;

    @Column(nullable = false)
    private Integer cupoMaximo;

    @Column(nullable = false)
    private Integer cupoMinimo;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @ManyToOne
    @JoinColumn(name = "id_franja")
    private FranjaHoraria franja;

    public void asignarDocente(Docente docente) { this.docente = docente; }
    public void asignarAula(Aula aula)           { this.aula = aula; }
    public void asignarFranja(FranjaHoraria f)   { this.franja = f; }

    public boolean tieneConflictoHorario() {
        return EstadoSeccion.CONFLICTO.equals(this.estadoSeccion);
    }

    public boolean estaCompleta() {
        return docente != null && aula != null && franja != null;
    }

    public boolean cumpleMinimo() {
        return cupoMinimo != null && cupoMinimo > 0;
    }
}
