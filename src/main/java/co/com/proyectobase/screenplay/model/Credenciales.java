package co.com.proyectobase.screenplay.model;
import co.com.proyectobase.screenplay.model.builder.CredencialesBuilder;

public class Credenciales {
    private String usuario;
    private String contrasenia;


    public Credenciales(CredencialesBuilder builder) {
        this.usuario =builder.getUsuarioBuild();
        this.contrasenia=builder.getContraseniaBuild();
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
