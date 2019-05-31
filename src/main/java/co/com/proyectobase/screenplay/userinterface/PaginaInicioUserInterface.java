package co.com.proyectobase.screenplay.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://operacion.choucairtesting.com/MaxtimeChc")
public class PaginaInicioUserInterface extends PageObject{

    public static final Target LBL_NOMBRE = Target.the("Lbl nombre usuario")
            .locatedBy("//td[contains(text(),'Nombre de usuario')]");

    public static final Target USUARIO = Target.the("Input nombre usuario")
            .locatedBy("//input[contains(@name, 'UserName')]");

    public static final Target CONTRASENNA = Target.the("Input contraseña")
            .locatedBy("//input[contains(@name, 'Password')]");

    public static final Target INGRESAR = Target.the("Botón conectarse")
            .locatedBy("//a[contains(@title, 'Conectarse')]");
}
