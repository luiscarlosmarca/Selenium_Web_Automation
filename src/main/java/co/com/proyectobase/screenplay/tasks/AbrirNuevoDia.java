package co.com.proyectobase.screenplay.tasks;

import co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class AbrirNuevoDia implements Task {

    public AbrirNuevoDia() {

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

    }

    public static ReportarDiaLaborado Ordinario(InformacionLaboralBuilder informacionLaboral) {
        return Tasks.instrumented(ReportarDiaLaborado.class, informacionLaboral.build());
    }
}
