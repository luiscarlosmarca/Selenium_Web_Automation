package co.com.proyectobase.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.tools.ant.taskdefs.Tar;
import org.joda.time.DateTime;

import java.text.Format;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.*;
import static co.com.proyectobase.screenplay.util.Constantes.DIA_REPORTADO;
import java.util.Date;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarFecha implements Question<Boolean> {

    private Target target;
    private Boolean reportarDia=true;
    public VerificarFecha(Target target, boolean reportarDia) {

        this.target=target;
        this.reportarDia=reportarDia;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo((WaitUntil.the(target.of(ObtenerEldiaSiguiente(actor)), isVisible()).forNoMoreThan(60).seconds()));

        actor.attemptsTo(
                (Check.whether(reportarDia).andIfSo(
                            (WaitUntil.the(target.of(ObtenerEldiaSiguiente(actor)), isVisible()).forNoMoreThan(60).seconds()))
                        .otherwise(
                                (WaitUntil.the(target, isVisible()).forNoMoreThan(60).seconds())
                        )
                )
        );

        Target verificarFecha=(reportarDia)?target.of(ObtenerEldiaSiguiente(actor)):target;
        return Visibility.of(verificarFecha).viewedBy(actor).asBoolean();
    }

    private String ObtenerEldiaSiguiente(Actor actor) {
        String diaReportado= actor.recall(DIA_REPORTADO);
        String [] diaReportadoArray = diaReportado.split("/");
        int dia=Integer.parseInt(diaReportadoArray[0])+1;
        diaReportadoArray[0]=Integer.toString(dia);
        String diaSiguiente=diaReportadoArray[0]+"/"+diaReportadoArray[1]+"/"+diaReportadoArray[2];
        return diaSiguiente;
    }


    public static VerificarFecha delDiaSiguiente() {
        return new VerificarFecha(LBL_FECHA_DASHBOARD,true);
    }
    public static VerificarFecha correctamente() {
        return new VerificarFecha(LBL_FECHA_DASHBOARD,false);
    }
}
