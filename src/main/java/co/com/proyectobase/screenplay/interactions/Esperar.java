package co.com.proyectobase.screenplay.interactions;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.apache.xpath.operations.Bool;
import org.awaitility.Awaitility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import static co.com.proyectobase.screenplay.util.AjustarTiempos.condicionExitosa;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotVisible;
import static co.com.proyectobase.screenplay.userinterface.UtilUserInteface.FRAME_CARGANDO;

public class Esperar implements Interaction {
    private int segundos;
    Boolean carga=false;

    public Esperar(int segundos,Boolean carga) {
        this.segundos = segundos;
        this.carga=carga;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (carga){
            Boolean noEsVisible = true;
            while (noEsVisible){
                actor.attemptsTo(WaitUntil.the(FRAME_CARGANDO, isNotVisible()).forNoMoreThan(segundos).seconds());
                noEsVisible= Visibility.of(FRAME_CARGANDO).viewedBy(actor).asBoolean();
            }



        }else{
            Awaitility.await().forever().pollInterval(segundos, TimeUnit.SECONDS).until(condicionExitosa());
        }

    }

    /** Método de Espera implicita genérico, espera cantidad de segundos fijos
     * <p>&nbsp;</p>
     * <pre>
     * Espera.unMomento(10).performAs(actor);
     * </pre>
     * @param segundos Cantidad de segundos fijos a esperar
     * */
    public static Esperar unMomento(int segundos) {
        return Tasks.instrumented(Esperar.class, segundos,false);
    }

    public static Esperar carga(int segundos) {
        return Tasks.instrumented(Esperar.class, segundos,true);
    }
}
