package co.edu.unbosque.model;

import jakarta.persistence.*;

@Entity
@Table(name="bloque")
public class Bloque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bloque")
    private int idBloque;

    @Column(name="nombre_bloque")
    private String nombreBloque;

    @Column(name="etiqueta_bloque")
    private String etiquetaBloque;

    @Column(name="ubicacion")
    private String ubicacion;

    public int getIdBloque() {
        return idBloque;
    }

    public void setIdBloque(int idBloque) {
        this.idBloque = idBloque;
    }

    public String getNombreBloque() {
        return nombreBloque;
    }

    public void setNombreBloque(String nombreBloque) {
        this.nombreBloque = nombreBloque;
    }

    public String getEtiquetaBloque() {
        return etiquetaBloque;
    }

    public void setEtiquetaBloque(String etiquetaBloque) {
        this.etiquetaBloque = etiquetaBloque;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
