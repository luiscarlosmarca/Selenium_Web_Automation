package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.interactions.Esperar;
import co.com.proyectobase.screenplay.model.InformacionLaboral;
import co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.proyectobase.screenplay.userinterface.BotonesMenuVerticalUserInterface.BTN_EDITAR_REPORTE_DIA;
import static co.com.proyectobase.screenplay.userinterface.DiasCerradosUserInterface.*;
import static co.com.proyectobase.screenplay.userinterface.DiasCerradosUserInterface.LBL_DIA_REPORTADO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarYSeleccionar implements Task {
    private InformacionLaboral infoLaboral;
    public BuscarYSeleccionar(InformacionLaboral infoLaboral) {
        this.infoLaboral=infoLaboral;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Esperar.unMomento(3),(WaitUntil.the(TXT_BUSCAR_DIAS, isVisible()).forNoMoreThan(10).seconds()),
                Enter.theValue(infoLaboral.getFecha()).into(TXT_BUSCAR_DIAS),
                Click.on(BTN_BUSCAR_DIAS),Esperar.unMomento(3),
                (WaitUntil.the(GRID_DIAS_REPORTADOS.of(infoLaboral.getFecha()),isVisible()).forNoMoreThan(30).seconds()),
                Click.on(GRID_DIAS_REPORTADOS.of(infoLaboral.getFecha())),(WaitUntil.the(LBL_DIA_REPORTADO,isVisible()).forNoMoreThan(30).seconds()),
                Click.on(LBL_DIA_REPORTADO),(WaitUntil.the(BTN_EDITAR_REPORTE_DIA,isVisible()).forNoMoreThan(30).seconds()),
                Click.on(BTN_EDITAR_REPORTE_DIA));
        Esperar.unMomento(5);
    }
    public static BuscarYSeleccionar elDiaQueVoyAModificar(InformacionLaboralBuilder infoLaboral) {
        return Tasks.instrumented(BuscarYSeleccionar.class,infoLaboral.build());
    }
}
