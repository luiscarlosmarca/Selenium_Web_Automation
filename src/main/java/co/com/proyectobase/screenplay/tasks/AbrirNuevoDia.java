package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.interactions.Esperar;
import co.com.proyectobase.screenplay.model.InformacionLaboral;
import co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.proyectobase.screenplay.userinterface.DashboardReporteTiempos.LBL_FECHA_DASHBOARD;
import static co.com.proyectobase.screenplay.userinterface.DashboardReporteTiempos.TD_FECHA_DASHBOARD;
import static co.com.proyectobase.screenplay.userinterface.DashboardReporteTiempos.TITULO_PAGINA_DASHBOARD_REPORTE_TIEMPO;
import static co.com.proyectobase.screenplay.userinterface.DashboardReporteTiempos.TITULO_PAGINA_REPORTE_DIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AbrirNuevoDia implements Task {
     private  InformacionLaboral infoLaboral;

    public AbrirNuevoDia(InformacionLaboral infoLaboral) {
        this.infoLaboral=infoLaboral;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Esperar.unMomento(2),
                WaitUntil.the(LBL_FECHA_DASHBOARD.of(infoLaboral.getFecha()), isVisible()).forNoMoreThan(10).seconds());

        actor.attemptsTo(Click.on(TD_FECHA_DASHBOARD));
        actor.attemptsTo(Check.whether(!CurrentVisibility.of(TITULO_PAGINA_REPORTE_DIA).viewedBy(actor).asBoolean()).andIfSo(
                Click.on(TD_FECHA_DASHBOARD)));
    }

    public static AbrirNuevoDia paraReportar(InformacionLaboralBuilder informacionLaboral) {
        return Tasks.instrumented(AbrirNuevoDia.class, informacionLaboral.build());
    }
}
