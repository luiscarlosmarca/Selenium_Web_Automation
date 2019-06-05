package co.com.proyectobase.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class UtilUserInteface {


    public static final Target FRAME_CARGANDO = Target.the("Frame cargando")
            .locatedBy(" //span[@id='ProgressControl']//span[contains(text(),'Cargando')]");
}
