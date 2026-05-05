package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoAula;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.TipoAula;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.AulaRequerida;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "aulas")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Aula {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAula;

    @Column(nullable = false, unique = true, length = 20)
    private String codigoAula;

    @Column(nullable = false)
    private Integer capacidad;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAula tipoAula;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoAula estadoAula;

    @ManyToOne
    @JoinColumn(name = "id_bloque")
    private Bloque bloque;

    public boolean estaDisponible(FranjaHoraria franjaHoraria) {
        return EstadoAula.DISPONIBLE.equals(this.estadoAula);
    }

    public boolean tieneCapacidad(int inscritos) {
        return this.capacidad >= inscritos;
    }

    public boolean cumpleTipoRequerido(AulaRequerida requerida) {
        if (requerida == null || AulaRequerida.NINGUNA.equals(requerida)) return true;
        return this.tipoAula.name().equals(requerida.name());
    }

    public boolean estaEnMantenimiento() {
        return EstadoAula.MANTENIMIENTO.equals(this.estadoAula);
    }
}
