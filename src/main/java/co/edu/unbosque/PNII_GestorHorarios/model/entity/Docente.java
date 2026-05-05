package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "docentes")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Docente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocente;

    @Column(nullable = false, length = 100)
    private String nombreDocente;

    @Column(nullable = false, length = 100)
    private String apellidoDocente;

    @Column(unique = true, length = 100)
    private String correo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Escalafon escalafon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoDocente estadoDocente;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoVinculacion tipoVinculacion;

    @Column(nullable = false)
    private Integer horasAsignadas;

    /** Límite semanal según tipo de vinculación */
    public int limiteHorasSemanales() {
        return TipoVinculacion.TCMTO.equals(tipoVinculacion) ? 24 : 12;
    }

    public boolean estaDisponible(FranjaHoraria franjaHoraria) {
        return EstadoDocente.ACTIVO.equals(this.estadoDocente);
    }

    public Integer obtenerHorasAsignadas() {
        return this.horasAsignadas;
    }

    public boolean tieneCupoHoras() {
        return this.horasAsignadas < limiteHorasSemanales();
    }

    public boolean cumpleJornada(FranjaHoraria franja) {
        return franja != null && franja.estaEnRangoPermitido();
    }
}
