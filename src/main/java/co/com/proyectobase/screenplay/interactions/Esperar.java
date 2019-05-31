package co.com.proyectobase.screenplay.interactions;

import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import static co.com.proyectobase.screenplay.util.AjustarTiempos.condicionExitosa;

public class Esperar implements Interaction {
    private int segundos;

    public Esperar(int segundos) {
        this.segundos = segundos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Awaitility.await().forever().pollInterval(segundos, TimeUnit.SECONDS).until(condicionExitosa());
    }

    /** Método de Espera implicita genérico, espera cantidad de segundos fijos
     * <p>&nbsp;</p>
     * <pre>
     * Espera.unMomento(10).performAs(actor);
     * </pre>
     * @param segundos Cantidad de segundos fijos a esperar
     * */
    public static Esperar unMomento(int segundos) {
        return Tasks.instrumented(Esperar.class, segundos);
    }
}
