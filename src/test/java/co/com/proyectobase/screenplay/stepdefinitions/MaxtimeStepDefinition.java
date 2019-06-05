package co.com.proyectobase.screenplay.stepdefinitions;
import co.com.proyectobase.screenplay.exceptions.NoCargaLaPantallaDelDashboard;
import co.com.proyectobase.screenplay.exceptions.NoCargaLaPantallaDiasCerradosException;
import co.com.proyectobase.screenplay.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import co.com.proyectobase.screenplay.model.DatosParaIngresar;
import co.com.proyectobase.screenplay.questions.VerificarFecha;

import static  co.com.proyectobase.screenplay.util.Constantes.NAVEGADOR;

import static co.com.proyectobase.screenplay.model.builder.CredencialesBuilder.credenciales;
import static co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder.infoLaboralPorDefecto;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class MaxtimeStepDefinition {

    @Managed(driver = NAVEGADOR)
    private WebDriver suNavegador;
    public static final Actor LUISCA = Actor.named("LuisCa");

    @Before
    public void inicializacion() {
        LUISCA.can(BrowseTheWeb.with(suNavegador));
    }
    @Dado("^que LuisCa quiere loguearse en la aplicación de maxtime$")
    public void queLuisCaQuiereLoguearseEnLaAplicaciónDeMaxtime() {
        LUISCA.wasAbleTo((AbrirElNavegador.enLaAplicacionDeMaxtime()));
    }

    @Cuando("^iniciar sesión$")
    public void iniciarSesión() {

        LUISCA.attemptsTo(IniciarSesion.EnMaxTime(credenciales().conElusuarioDefault()));
    }

    @Cuando("^diligencia los datos necesarios para reportar$")
    public void diligenciaLosDatosNecesariosParaReportar(List<DatosParaIngresar> dataTable) {

        for (int i = 0; i < dataTable.size(); i++) {
            DatosParaIngresar datos = dataTable.get(i);
            LUISCA.attemptsTo(AbrirNuevoDia.paraReportar(infoLaboralPorDefecto()));
            LUISCA.attemptsTo(ReportarDiaLaborado.Ordinario(infoLaboralPorDefecto().conProyecto(datos.getProyecto()).
                    conActividad(datos.getActividad()).conFecha(datos.getFecha()).isDiaHabil(datos.getDiaHabil())));
        }

    }

    @Entonces("^la solicitud debe de quedar guardada correctamente$")
    public void laSolicitudDebeDeQuedarGuardadaCorrectamente()  {
        LUISCA.should(seeThat(VerificarFecha.delDiaSiguiente()).orComplainWith(NoCargaLaPantallaDelDashboard.class,
                NoCargaLaPantallaDelDashboard.MESSAGE_EXCEPTION_CARGAR_PANTALLA_DASHBOARD));
    }

    @Cuando("^diligencia los datos necesarios para modificar$")
    public void diligenciaLosDatosNecesariosParaModifica(List<DatosParaIngresar> dataTable) {
        for (int i = 0; i < dataTable.size(); i++) {
            DatosParaIngresar datos = dataTable.get(i);
            LUISCA.attemptsTo(AbrirDiasCerrados.enDiasAnteriores());
            LUISCA.attemptsTo(BuscarYSeleccionar.elDiaQueVoyAModificar(infoLaboralPorDefecto().conFecha(datos.getFecha())));
            LUISCA.attemptsTo(ModificarDiasReportados.con(infoLaboralPorDefecto().conProyecto(datos.getProyecto()).
                    conActividad(datos.getActividad()).conFecha(datos.getFecha())));
            LUISCA.attemptsTo(CerrarDia.correctamente());
        }
    }

    @Entonces("^la solicitud debe de quedar modificada correctamente$")
    public void laSolicitudDebeDeQuedarModificadaCorrectamente() {
        LUISCA.should(seeThat(VerificarFecha.correctamente()).orComplainWith(NoCargaLaPantallaDelDashboard.class,
                NoCargaLaPantallaDiasCerradosException.MESSAGE_EXCEPTION_CARGAR_PANTALLA_DIAS_CERRADOS));
    }


}
