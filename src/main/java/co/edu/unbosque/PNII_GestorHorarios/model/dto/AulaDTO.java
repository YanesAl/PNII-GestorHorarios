package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AulaDTO {
    private Integer idAula;
    private String codigoAula;
    private Integer capacidad;
    private TipoAula tipoAula;
    private EstadoAula estadoAula;
    private String nombreBloque;
}
