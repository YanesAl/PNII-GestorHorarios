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
@Table(name="facultad")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Facultad {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idFacultad;

    @OneToMany (mappedBy = "facultad")
    private List<Area>areas;


}
