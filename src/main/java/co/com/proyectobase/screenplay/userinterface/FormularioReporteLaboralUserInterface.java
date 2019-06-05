package co.com.proyectobase.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class FormularioReporteLaboralUserInterface {
    //dashboard

    public static final Target TITULO_PAGINA_REPORTE_DIA = Target.the("Titulo de la pagina del reporte")
            .locatedBy("//h1/span[contains(text(),'Reporte Dia')]");
    public static final Target TITULO_PAGINA_REPORTE_DIAS_CERRADOS= Target.the("Titulo de la pagina del reporte")
            .locatedBy("//h1/span[contains(text(),'Abrir Dias Cerrados')]");

    public static final Target LBL_FECHA_DASHBOARD = Target.the("lbl fecha reporte dashboard")
            .locatedBy("//*[contains(text(), '{0}')]");
    public static final Target TD_FECHA_DASHBOARD = Target.the("lbl fecha reporte dashboard")
            .locatedBy("#Vertical_v1_LE_v2_tccell0_0");

    public static final Target BTN_BUSCAR_PROYECTOS = Target.the("Boton para buscar en el frame")
            .locatedBy("//img[contains(@id,'Proyecto_Edit_Find')]");



    public static final IFrame IFRAME= IFrame.withPath(By.xpath("//iframe"));
    public static final IFrame IFRAME_ACTIVIDAD= IFrame.withPath(By.xpath("//iframe[contains(@src,'Dia')]"));


    public static final Target TXT_BUSCAR_FRAME = Target.the("Input text para buscar frame").inIFrame(IFRAME)
                .locatedBy("//input[contains(@name,'SearchActionContainer')][@type='text']");

    public static final Target BTN_BUSCAR_FRAME = Target.the("Boton para buscar frame").inIFrame(IFRAME)
            .locatedBy("//span[contains(text(),'Search')]");

    public static final Target TXT_BUSCAR_FRAME_ACTIVIDAD = Target.the("Input text para buscar frame de actividades para modificacion").inIFrame(IFRAME_ACTIVIDAD)
            .locatedBy("//input[contains(@name,'SearchActionContainer')][@type='text']");

    public static final Target BTN_BUSCAR_FRAME_ACTIVIDAD = Target.the("Boton para buscar frame de actividades para modificacion").inIFrame(IFRAME_ACTIVIDAD)
            .locatedBy("//span[contains(text(),'Search')]");

    public static final Target LBL_TABLE_FRAME_PROYECTOS = Target.the("Grid proyectos lbl proyectos").inIFrame(IFRAME)
            .locatedBy("//span[contains(@id,'CodigoCliente_View')][contains(text(), '{0}')]");

    public static final Target LBL_TABLE_FRAME_ACTIVIDADES = Target.the("Grid proyectos lbl proyectos").inIFrame(IFRAME_ACTIVIDAD)
            .locatedBy("//span[contains(@id,'Nombre_View')][contains(text(), '{0}')]");// Solo para el caso de modificacion.


    public static final Target LBL_TABLE_FRAME_SERVICIOS = Target.the("Grid proyectos lbl servicios").inIFrame(IFRAME)
            .locatedBy("//span[contains(@id,'Nombre_View')][contains(text(), '{0}')]");


    public static final Target ICON_CMB_TIPO_HORA = Target.the("icono Lista de tipo de hora")
            .locatedBy("//img[contains(@id,'TipoHora_Edit_DD')]");

    public static final Target CMB_TIPO_HORA = Target.the("Lista de tipo de hora")
            .locatedBy("//td[contains(@id,'TipoHora_Edit_DD')][contains(text(), '{0}')]");


    public static final Target BTN_BUSCAR_SERVICIO = Target.the("icono Lista de servicio")
            .locatedBy("//div[contains(@id,'Servicio_Edit_Find')]");
    public static final Target ICON_CMB_ACTIVIDAD = Target.the("icono Lista de actividades")
            .locatedBy("//div[contains(@id,'Actividad_Edit_Find')]");


    public static final Target CMB_ACTIVIDAD = Target.the("Lista de actividades")
            .locatedBy("//td[contains(@id,'Actividad_Edit_DD')][contains(text(), '{0}')]");

    public static final Target TXT_HORAS_EJECUTADAS = Target.the("Input text horas ejecutadas")
            .locatedBy("//input[contains(@id,'Horas_Edit')]");

    public static final Target TXT_COMENTARIO = Target.the("Input text comentario")
            .locatedBy("//input[contains(@id,'Comentario')]");

    public static final Target BTN_GUARDAR_Y_CERRAR = Target.the("Input text comentario")
            .locatedBy("//div[contains(@id,'Vertical_EditModeActions2_Menu_DXI1_T')]");

    public static final Target BTN_CERRAR_FRAME_REPORTE_DIA= Target.the("Boton de cerrar frame de reporte de dia").inIFrame(IFRAME)
            .locatedBy("//div[contains(@id,'Holder_Menu_DXI0_')]");



}
