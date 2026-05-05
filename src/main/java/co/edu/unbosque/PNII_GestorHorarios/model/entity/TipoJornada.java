package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.Categoria;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tipos_jornada")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class TipoJornada {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJornada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categoria categoria;

    @Column(nullable = false)
    private Boolean esPrioridad;
}
