package co.com.proyectobase.screenplay.exceptions;

public class NoCargaLaPantallaDiasCerradosException extends AssertionError {
    public static final long serialVersionUID =11L;
    public static final String MESSAGE_EXCEPTION_CARGAR_PANTALLA_DIAS_CERRADOS = "No se puede cargar la pantalla repote de dias cerrados";

    public NoCargaLaPantallaDiasCerradosException(String message, Throwable cause) {
        super(message, cause);
    }
}
