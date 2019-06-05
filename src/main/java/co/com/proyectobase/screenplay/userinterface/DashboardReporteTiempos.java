package co.com.proyectobase.screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class DashboardReporteTiempos {

    public static final Target TITULO_PAGINA_DASHBOARD_REPORTE_TIEMPO = Target.the("Lbl nombre usuario")
            .locatedBy("//span[contains(text(),'Reporte de tiempos')]");

    public static final Target LBL_FECHA_DASHBOARD = Target.the("lbl fecha reporte dashboard")
            .locatedBy("//*[contains(text(), '{0}')]");
    public static final Target TD_FECHA_DASHBOARD = Target.the("lbl fecha reporte dashboard")
            .locatedBy("#Vertical_v1_LE_v2_tccell0_0");
}
