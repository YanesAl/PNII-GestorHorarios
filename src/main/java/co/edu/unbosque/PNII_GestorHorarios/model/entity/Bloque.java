package co.edu.unbosque.PNII_GestorHorarios.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bloques")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Bloque {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBloque;

    @Column(nullable = false, length = 100)
    private String nombreBloque;

    @Column(length = 50)
    private String etiquetaBloque;

    @Column(length = 200)
    private String ubicacion;

    public boolean seSolapaCon(FranjaHoraria otraFranja) {
        // placeholder — la lógica real consulta las secciones asignadas al bloque
        return false;
    }
}
