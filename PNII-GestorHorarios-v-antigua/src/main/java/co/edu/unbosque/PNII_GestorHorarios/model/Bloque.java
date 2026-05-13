package co.edu.unbosque.PNII_GestorHorarios.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="bloque")
@NoArgsConstructor
@AllArgsConstructor

public class Bloque {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idBloque;


    private String nombreBloque;
    private String etiquetaBloque;
    private String ubicacion;

    @OneToMany (mappedBy = "area")
    private List<Aula>aulas;


    public Aula buscarAula(int id){
        for(Aula salon:aulas){
            if(salon.getIdAula()==id){
                return salon;
            }
        }
        return null;
    }


}
