package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.exceptions.NoCargaLaPantallaDiasCerradosException;
import co.com.proyectobase.screenplay.interactions.Esperar;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.proyectobase.screenplay.userinterface.BotonesMenuVerticalUserInterface.BTN_ABRIR_DIAS_CERRADOS;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.TITULO_PAGINA_REPORTE_DIAS_CERRADOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirDiasCerrados implements Task {

    public AbrirDiasCerrados() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Esperar.carga(5));
        actor.attemptsTo(Click.on(BTN_ABRIR_DIAS_CERRADOS));
        actor.attemptsTo(Esperar.carga(10));

        verificaCarga(actor);
    }

    private void verificaCarga(Actor actor) {
        actor.attemptsTo((WaitUntil.the(TITULO_PAGINA_REPORTE_DIAS_CERRADOS,isVisible()).forNoMoreThan(30).seconds()));
        actor.should(seeThat(Visibility.of(TITULO_PAGINA_REPORTE_DIAS_CERRADOS).viewedBy(actor).asAQuestion()).orComplainWith(NoCargaLaPantallaDiasCerradosException.class,
                NoCargaLaPantallaDiasCerradosException.MESSAGE_EXCEPTION_CARGAR_PANTALLA_DIAS_CERRADOS));
    }

    public static AbrirDiasCerrados enDiasAnteriores() {
        return Tasks.instrumented(AbrirDiasCerrados.class);
    }
}
