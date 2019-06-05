package co.com.proyectobase.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.proyectobase.screenplay.userinterface.DashboardReporteTiempos.BTN_NUEVO_REPORTE;
public class CrearNuevoReporte implements Task {

    public CrearNuevoReporte() {
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo((WaitUntil.the(BTN_NUEVO_REPORTE,isVisible()).forNoMoreThan(30).seconds()),
                Click.on(BTN_NUEVO_REPORTE));
    }
    public  static CrearNuevoReporte deUnDiaNuevo(){
        return Tasks.instrumented(CrearNuevoReporte.class);

    }
}
