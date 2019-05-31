package co.com.proyectobase.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class BotonesMenuVerticalUserInterface {

    public static final Target BTN_NUEVO_REPORTE_DIA = Target.the("Boton para crear un nuevo reporte")
            .locatedBy("//a[contains(@title,'Nuevo Detalle Reporte Dia')]");

    public static final Target BTN_CERRAR_REPORTE_DIA = Target.the("Boton para cerrar un nuevo reporte")
            .locatedBy("#Vertical_TB_Menu_DXI1_T");

}
