package co.com.proyectobase.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DiasCerrados {

    public static final Target BTN_ABRIR_DIAS_CERRADOS = Target.the("Boton para ver los dias reportados")
            .locatedBy("//input[contains(@value,'Text to search')]");
    
}


