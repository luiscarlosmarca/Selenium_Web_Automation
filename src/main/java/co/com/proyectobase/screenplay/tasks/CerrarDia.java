package co.com.proyectobase.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.proyectobase.screenplay.userinterface.BotonesMenuVerticalUserInterface.BTN_CERRAR_REPORTE_DIA;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.BTN_CERRAR_FRAME_REPORTE_DIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CerrarDia implements Task {

    public CerrarDia() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(WaitUntil.the(BTN_CERRAR_REPORTE_DIA,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CERRAR_REPORTE_DIA),
                (WaitUntil.the(BTN_CERRAR_FRAME_REPORTE_DIA,isVisible()).forNoMoreThan(60).seconds()),
                Click.on(BTN_CERRAR_FRAME_REPORTE_DIA));

    }

    public static CerrarDia correctamente( ) {
        return Tasks.instrumented(CerrarDia.class);

    }
}
