package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.*;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DocenteDTO {
    private Integer idDocente;
    private String nombreDocente;
    private String apellidoDocente;
    private String correo;
    private Escalafon escalafon;
    private EstadoDocente estadoDocente;
    private TipoVinculacion tipoVinculacion;
    private Integer horasAsignadas;
    private Integer limiteHoras;
}
