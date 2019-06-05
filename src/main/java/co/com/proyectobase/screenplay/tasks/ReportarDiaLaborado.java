package co.com.proyectobase.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import co.com.proyectobase.screenplay.model.InformacionLaboral;
import co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder;
import co.com.proyectobase.screenplay.exceptions.NoCargaLaPantallaReporteDiaException;
import co.com.proyectobase.screenplay.interactions.Esperar;
import co.com.proyectobase.screenplay.tasks.CerrarDia;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.TITULO_PAGINA_REPORTE_DIA;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.LBL_FECHA_DASHBOARD;
import static co.com.proyectobase.screenplay.userinterface.BotonesMenuVerticalUserInterface.BTN_NUEVO_REPORTE_DIA;
import static co.com.proyectobase.screenplay.userinterface.BotonesMenuVerticalUserInterface.BTN_CERRAR_REPORTE_DIA;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.BTN_BUSCAR_PROYECTOS;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.TXT_BUSCAR_FRAME;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.BTN_BUSCAR_FRAME;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.LBL_TABLE_FRAME_PROYECTOS;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.LBL_TABLE_FRAME_SERVICIOS;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.CMB_TIPO_HORA;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.ICON_CMB_TIPO_HORA;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.BTN_BUSCAR_SERVICIO;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.ICON_CMB_ACTIVIDAD;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.CMB_ACTIVIDAD;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.*;
import static co.com.proyectobase.screenplay.util.Constantes.DIA_REPORTADO;

public class ReportarDiaLaborado implements Task {
    private InformacionLaboral infoLaboral;
    public ReportarDiaLaborado(InformacionLaboral infoLaboral) {
        this.infoLaboral=infoLaboral;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(LBL_FECHA_DASHBOARD.of(infoLaboral.getFecha()), isVisible()).forNoMoreThan(10).seconds());

        actor.attemptsTo(Click.on(TD_FECHA_DASHBOARD));
        actor.attemptsTo(Check.whether(!CurrentVisibility.of(TITULO_PAGINA_REPORTE_DIA).viewedBy(actor).asBoolean()).andIfSo(
                Click.on(TD_FECHA_DASHBOARD)));
        verificaCarga(actor);
        if (infoLaboral.isDiaHabil()){
            reportarDiaHabil(actor);
        }else {
            CerrarDia.correctamente();
            capturarValores(actor);
        }

    }


    private void reportarDiaHabil(Actor actor) {
        actor.attemptsTo(WaitUntil.the(BTN_NUEVO_REPORTE_DIA,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTN_NUEVO_REPORTE_DIA));
        Esperar.unMomento(5);
        actor.attemptsTo(WaitUntil.the(BTN_BUSCAR_PROYECTOS,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(BTN_BUSCAR_PROYECTOS));

        actor.attemptsTo(WaitUntil.the(TXT_BUSCAR_FRAME,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(infoLaboral.getProyecto()).into(TXT_BUSCAR_FRAME),
                Click.on(BTN_BUSCAR_FRAME),
                (WaitUntil.the(LBL_TABLE_FRAME_PROYECTOS.of(infoLaboral.getProyecto()),isVisible()).forNoMoreThan(60).seconds()),
                Click.on(LBL_TABLE_FRAME_PROYECTOS.of(infoLaboral.getProyecto())));

        actor.attemptsTo(WaitUntil.the(ICON_CMB_TIPO_HORA,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(ICON_CMB_TIPO_HORA),(WaitUntil.the(CMB_TIPO_HORA.of(infoLaboral.getTipoHora()),isVisible()).forNoMoreThan(60).seconds()),
                Click.on(CMB_TIPO_HORA.of(infoLaboral.getTipoHora())));

        Esperar.unMomento(2).performAs(actor);
        actor.attemptsTo(WaitUntil.the(BTN_BUSCAR_SERVICIO,isVisible()).forNoMoreThan(60).seconds());
        actor.attemptsTo(Click.on(BTN_BUSCAR_SERVICIO));

        actor.attemptsTo(WaitUntil.the(TXT_BUSCAR_FRAME,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(infoLaboral.getServicio()).into(TXT_BUSCAR_FRAME),
                Click.on(BTN_BUSCAR_FRAME));

        actor.attemptsTo((WaitUntil.the(LBL_TABLE_FRAME_SERVICIOS.of(infoLaboral.getServicio()),isVisible()).forNoMoreThan(60).seconds()),
                Click.on(LBL_TABLE_FRAME_SERVICIOS.of(infoLaboral.getServicio())));

        actor.attemptsTo(WaitUntil.the(ICON_CMB_ACTIVIDAD,isVisible()).forNoMoreThan(60).seconds(),
                Click.on(ICON_CMB_ACTIVIDAD),
                Click.on(CMB_ACTIVIDAD.of(infoLaboral.getActividad())));

        actor.attemptsTo(WaitUntil.the(TXT_HORAS_EJECUTADAS,isVisible()).forNoMoreThan(60).seconds(),
                Enter.theValue(infoLaboral.getHoraEjecutada()).into(TXT_HORAS_EJECUTADAS),
                Enter.theValue(infoLaboral.getComentario()).into(TXT_COMENTARIO),
                Click.on(BTN_GUARDAR_Y_CERRAR));

        CerrarDia.correctamente();
        capturarValores(actor);
    }

    private void capturarValores(Actor actor) {
        actor.remember(DIA_REPORTADO, infoLaboral.getFecha());
    }

    private void verificaCarga(Actor actor) {
        actor.attemptsTo((WaitUntil.the(TITULO_PAGINA_REPORTE_DIA,isVisible()).forNoMoreThan(30).seconds()));
        actor.should(seeThat(Visibility.of(TITULO_PAGINA_REPORTE_DIA).viewedBy(actor).asAQuestion()).orComplainWith(NoCargaLaPantallaReporteDiaException.class, NoCargaLaPantallaReporteDiaException.MESSAGE_EXCEPTION_CARGAR_PANTALLA_REPORTE_DIA));

    }



    public static ReportarDiaLaborado Ordinario(InformacionLaboralBuilder informacionLaboral) {
        return Tasks.instrumented(ReportarDiaLaborado.class, informacionLaboral.build());
    }
}
