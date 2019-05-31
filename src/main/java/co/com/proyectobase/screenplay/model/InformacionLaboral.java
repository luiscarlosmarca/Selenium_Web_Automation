package co.com.proyectobase.screenplay.model;
import co.com.proyectobase.screenplay.model.builder.InformacionLaboralBuilder;
public class InformacionLaboral {

    private String proyecto;
    private String fecha;
    private String tipoHora;
    private String servicio;
    private String actividad;
    private String horaEjecutada;
    private String comentario;
    private boolean diahabil;



    public InformacionLaboral(InformacionLaboralBuilder builder) {
        this.proyecto = builder.getProyectoBuild();
        this.fecha = builder.getFechaBuild();
        this.tipoHora = builder.getTipoHoraBuild();
        this.servicio = builder.getServicioBuild();
        this.actividad = builder.getActividadBuild();
        this.horaEjecutada = builder.getHoraEjecutadaBuild();
        this.comentario = builder.getComentarioBuild();
        this.diahabil=builder.isDiaHabilBuild();
    }

    public String getFecha() {
        return fecha;
    }
    public boolean isDiaHabil() {
        return diahabil;
    }
    public String getProyecto() {
        return proyecto;
    }

    public String getTipoHora() {
        return tipoHora;
    }

    public String getServicio() {
        return servicio;
    }

    public String getActividad() {
        return actividad;
    }

    public String getHoraEjecutada() {
        return horaEjecutada;
    }

    public String getComentario() {
        return comentario;
    }
}
