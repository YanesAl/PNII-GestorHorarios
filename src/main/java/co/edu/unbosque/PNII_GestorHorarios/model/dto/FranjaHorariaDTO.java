package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.DiaSemana;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoFranja;
import lombok.*;
import java.time.LocalTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class FranjaHorariaDTO {
    private Integer idFranja;
    private DiaSemana diaSemana;
    private EstadoFranja estadoFranja;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
