package co.com.proyectobase.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import co.com.proyectobase.screenplay.model.Credenciales;
import net.serenitybdd.screenplay.Task;
import co.com.proyectobase.screenplay.model.builder.CredencialesBuilder;
import static co.com.proyectobase.screenplay.userinterface.PaginaInicioUserInterface.USUARIO;
import static co.com.proyectobase.screenplay.userinterface.PaginaInicioUserInterface.CONTRASENNA;
import static co.com.proyectobase.screenplay.userinterface.PaginaInicioUserInterface.INGRESAR;


public class IniciarSesion implements Task {

    private Credenciales credenciales;

    public IniciarSesion(Credenciales credenciales) {
        this.credenciales = credenciales;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credenciales.getUsuario()).into(USUARIO),
                Enter.theValue(credenciales.getContrasenia()).into(CONTRASENNA));
        actor.attemptsTo(Click.on(INGRESAR));
    }

    public static IniciarSesion EnMaxTime(CredencialesBuilder credenciales) {

        return Tasks.instrumented(IniciarSesion.class, credenciales.build());
    }
}
