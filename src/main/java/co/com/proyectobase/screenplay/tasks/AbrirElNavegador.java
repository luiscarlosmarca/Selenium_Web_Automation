package co.com.proyectobase.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import co.com.proyectobase.screenplay.userinterface.PaginaInicioUserInterface;

public class AbrirElNavegador implements Task {

    private PaginaInicioUserInterface paginaInicioUserInterface;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(paginaInicioUserInterface));
    }

    public static AbrirElNavegador enLaAplicacionDeMaxtime() {

        return Tasks.instrumented(AbrirElNavegador.class);
    }
}
