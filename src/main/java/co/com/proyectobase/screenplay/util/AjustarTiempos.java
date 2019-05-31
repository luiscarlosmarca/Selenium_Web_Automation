package co.com.proyectobase.screenplay.util;
import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.temporal.TemporalUnit;
import java.util.concurrent.Callable;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
public class AjustarTiempos {
    static Boolean allMessagesProcessed = true;
    static TemporalUnit unit;

    private AjustarTiempos() {
    }

    public static Callable<Boolean> condicionExitosa() {
        return new Callable<Boolean>() {
            public Boolean call() throws Exception {
                return allMessagesProcessed;
            }
        };
    }

    public static void restaurarTiempoPorDefecto (Actor actor) {
        BrowseTheWeb.as(actor).resetImplicitTimeout();
    }

    public static void fijarSegundos (Actor actor, int segundos) {
        BrowseTheWeb.as(actor).setImplicitTimeout(segundos, SECONDS);
    }
}
