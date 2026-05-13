package co.edu.unbosque.PNII_GestorHorarios.model;

import jakarta.persistence.Entity;
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
@Table(name="area")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Area {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idArea;

    private String nombreArea;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_facultad")  
    private Facultad facultad;

    public boolean pertenenceAFacultad(Facultad facultadVerificar){
        return getFacultad().getIdFacultad()==facultadVerificar.getIdFacultad();

    }







}
