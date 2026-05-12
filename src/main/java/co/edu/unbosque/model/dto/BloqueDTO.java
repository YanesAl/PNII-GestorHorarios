package co.edu.unbosque.model.dto;

public class BloqueDTO {
    private int idBloque;
    private String nombreBloque;
    private String etiquetaBloque;
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
