package co.com.proyectobase.screenplay.exceptions;

public class NoCargaLaPantallaReporteDiaException extends AssertionError {

    public static final long serialVersionUID =11L;
    public static final String MESSAGE_EXCEPTION_CARGAR_PANTALLA_REPORTE_DIA = "No se puede cargar la pantalla de reporte de dia";

    public NoCargaLaPantallaReporteDiaException(String message, Throwable cause) {
        super(message, cause);
    }
}
