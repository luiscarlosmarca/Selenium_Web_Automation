package co.com.proyectobase.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.targets.Target;
import org.joda.time.DateTime;

import java.text.Format;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import static co.com.proyectobase.screenplay.userinterface.FormularioReporteLaboralUserInterface.LBL_FECHA_DASHBOARD;
import static co.com.proyectobase.screenplay.util.Constantes.DIA_REPORTADO;
import java.util.Date;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarFecha implements Question<Boolean> {

    private Target target;
    public VerificarFecha(Target target) {

        this.target=target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo((WaitUntil.the(target.of(ObtenerEldiaSiguiente(actor)), isVisible()).forNoMoreThan(60).seconds()));
        return Visibility.of(target.of(ObtenerEldiaSiguiente(actor))).viewedBy(actor).asBoolean();
    }

    private String ObtenerEldiaSiguiente(Actor actor) {
        String diaReportado= actor.recall(DIA_REPORTADO);
        String [] diaReportadoArray = diaReportado.split("/");
        int dia=Integer.parseInt(diaReportadoArray[0])+1;
        diaReportadoArray[0]=Integer.toString(dia);
        String diaSiguiente=diaReportadoArray[0]+"/"+diaReportadoArray[1]+"/"+diaReportadoArray[2];
        return diaSiguiente;
    }
    public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }

    public static VerificarFecha delDiaSiguiente() {
        return new VerificarFecha(LBL_FECHA_DASHBOARD);
    }
}
