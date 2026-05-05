package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.DiaSemana;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoFranja;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Table(name = "franjas_horarias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FranjaHoraria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFranja;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiaSemana diaSemana;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoFranja estadoFranja;

    @Column(nullable = false)
    private LocalTime horaInicio;

    @Column(nullable = false)
    private LocalTime horaFin;

    public boolean esBloqueada() {
        return EstadoFranja.BLOQUEADA.equals(this.estadoFranja);
    }

    public boolean estaEnRangoPermitido() {
        LocalTime inicio = LocalTime.of(6, 0);
        LocalTime fin    = LocalTime.of(22, 0);
        return !horaInicio.isBefore(inicio) && !horaFin.isAfter(fin);
    }

    public boolean seCruzanCon(FranjaHoraria otraFranja) {
        if (!this.diaSemana.equals(otraFranja.diaSemana)) return false;
        return this.horaInicio.isBefore(otraFranja.horaFin)
            && otraFranja.horaInicio.isBefore(this.horaFin);
    }
}
