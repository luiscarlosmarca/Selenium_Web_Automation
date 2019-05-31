package co.com.proyectobase.screenplay.exceptions;

public class NoCargaLaPantallaDelDashboard extends AssertionError {
    public static final long serialVersionUID =11L;
    public static final String MESSAGE_EXCEPTION_CARGAR_PANTALLA_DASHBOARD = "No se puede cargar la pantalla de reporte de dia";

    public NoCargaLaPantallaDelDashboard(String message, Throwable cause) {
        super(message, cause);
    }
}
