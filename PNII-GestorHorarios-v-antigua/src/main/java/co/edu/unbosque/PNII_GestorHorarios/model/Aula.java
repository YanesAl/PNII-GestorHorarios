package co.edu.unbosque.PNII_GestorHorarios.model;

import co.edu.unbosque.PNII_GestorHorarios.model.enums.EstadoAula;
import co.edu.unbosque.PNII_GestorHorarios.model.enums.TipoAula;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="aula")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAula;

    
    private int capacidad;


    @Enumerated(EnumType.STRING)
    private TipoAula tipoAula;

    @Enumerated(EnumType.STRING)
    private EstadoAula estadoAula;

    @ManyToOne
    @JoinColumn(name = "id_bloque")
    private Bloque bloque;

public boolean tieneCapacidad(int inscritos){
    return inscritos<capacidad;
    
}


public boolean cumpletTipoRequerido(TipoAula tipoRequerido){
   return this.tipoAula==tipoRequerido;
}

}
