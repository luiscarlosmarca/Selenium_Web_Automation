package co.com.proyectobase.screenplay.model;

public class DatosParaIngresar {

    private String proyecto;
    private String tipoHora;
    private String servicio;
    private String actividad;
    private String horaEjecutada;
    private String comentario;
    private String fecha;
    private Boolean diaHabil;

    public Boolean getDiaHabil() {
        return diaHabil;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getTipoHora() {
        return tipoHora;
    }

    public void setTipoHora(String tipoHora) {
        this.tipoHora = tipoHora;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getHoraEjecutada() {
        return horaEjecutada;
    }

    public void setHoraEjecutada(String horaEjecutada) {
        this.horaEjecutada = horaEjecutada;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
