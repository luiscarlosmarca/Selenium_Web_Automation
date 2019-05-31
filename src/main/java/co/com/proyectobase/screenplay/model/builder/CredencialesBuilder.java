package co.com.proyectobase.screenplay.model.builder;

import co.com.proyectobase.screenplay.model.Credenciales;
import co.com.proyectobase.screenplay.util.Builder;

public class CredencialesBuilder  implements Builder<Credenciales>{

    private String usuarioBuild;
    private String contraseniaBuild;


    public CredencialesBuilder() {
    }
    public CredencialesBuilder conElusuarioDefault () {
        this.usuarioBuild="lmarinc";
        this.contraseniaBuild="Mede987*-+";
        return this;
    }

    public static CredencialesBuilder credenciales() {
        return new CredencialesBuilder();
    }

    public CredencialesBuilder conUsuario(String usuario) {
        this.usuarioBuild = usuario;
        return this;
    }

    public CredencialesBuilder conContrasenia(String contrasenia) {
        this.contraseniaBuild = contrasenia;
        return this;
    }

    public String getUsuarioBuild() {
        return usuarioBuild;
    }

    public String getContraseniaBuild() {
        return contraseniaBuild;
    }

    @Override
    public Credenciales build() {
        return new Credenciales(this);
    }
}
