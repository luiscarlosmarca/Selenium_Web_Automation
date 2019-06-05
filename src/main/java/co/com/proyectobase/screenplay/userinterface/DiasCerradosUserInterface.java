package co.com.proyectobase.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DiasCerradosUserInterface {

    public static final Target TXT_BUSCAR_DIAS = Target.the("Boton para ver los dias reportados")
            .locatedBy("//input[contains(@value,'Text to search')]");
    public static final Target BTN_BUSCAR_DIAS = Target.the("Boton para ver los dias reportados")
            .locatedBy("//div/span[contains(text(),'Search')]");

    public static final Target GRID_DIAS_REPORTADOS = Target.the("Boton para ver los dias reportados")
            .locatedBy("//td/span[contains(@id,'Fecha_View')][contains(text(),'{0}')]");

    public static final Target LBL_DIA_REPORTADO = Target.the("Boton para ver los dias reportados")
            .locatedBy("//td/span[contains(@id,'Comentario_View')]");

    public static final Target TITULO_PAGINA_REPORTE_DIAS_CERRADOS= Target.the("Titulo de la pagina del reporte")
            .locatedBy("//h1/span[contains(text(),'Abrir Dias Cerrados')]");

}


