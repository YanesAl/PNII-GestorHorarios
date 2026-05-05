package co.edu.unbosque.PNII_GestorHorarios.model.dto;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoSeccion;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class SeccionDTO {
    private Integer idSeccion;
    private String codigo;
    private EstadoSeccion estadoSeccion;
    private Integer cupoMaximo;
    private Integer cupoMinimo;
    private String nombreCurso;
    private String nombreDocente;
    private String codigoAula;
    private String franjaDia;
    private String franjaHoraInicio;
    private String franjaHoraFin;
    private boolean completa;
    private boolean conflicto;
}
