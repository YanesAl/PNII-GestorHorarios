package co.edu.unbosque.PNII_GestorHorarios.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "carrera")
@NoArgsConstructor
@AllArgsConstructor
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrera;

    private String nombreCarrera;
    private String codigoCarrera;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PlanEstudios> planesEstudios = new ArrayList<>();

    public void agregarPlan(PlanEstudios plan) {
        planesEstudios.add(plan);
        plan.setCarrera(this);
    }

    public void eliminarPlan(PlanEstudios plan) {
        planesEstudios.remove(plan);
        plan.setCarrera(null);
    }

    public List<PlanEstudios> obtenerPlanes() {
        return planesEstudios;
    }

    public Boolean tienePlanesActivos() {
        return planesEstudios != null && !planesEstudios.isEmpty();
    }
}