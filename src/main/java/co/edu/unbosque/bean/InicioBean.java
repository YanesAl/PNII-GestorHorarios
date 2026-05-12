package co.edu.unbosque.bean;

import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("inicioBean")
@RequestScoped
public class InicioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mensaje="\n BIENVENIDO AL GENERADOR DE HORARIOS \n";

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}