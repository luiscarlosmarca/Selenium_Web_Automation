package co.com.proyectobase.screenplay.model.builder;

import co.com.proyectobase.screenplay.model.InformacionLaboral;
import co.com.proyectobase.screenplay.util.Builder;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
public class InformacionLaboralBuilder  implements Builder<InformacionLaboral>{

    private String proyectoBuild;
    private String fechaBuild;


    private String tipoHoraBuild;
    private String servicioBuild;
    private String actividadBuild;
    private String horaEjecutadaBuild;
    private String comentarioBuild;
    private boolean diaHabilBuild;



    public InformacionLaboralBuilder() {
        this.proyectoBuild = "GBCO24";
        this.tipoHoraBuild = "H. Choucair";
        this.servicioBuild = "P. generales CA CVDS ágiles";
        this.actividadBuild = "CAPACITACIÓN METODOLOGÍA DE PRUEBAS";
        this.horaEjecutadaBuild = "8";
        this.comentarioBuild = "Reto de maxtime, implementacion de proyecto usando builder";
        this.fechaBuild=hoy();
        this.diaHabilBuild=true;
    }

    public String hoy(){
        Format f = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = f.format(new Date());
        return strDate;
    }
    public boolean isDiaHabilBuild() {
        return diaHabilBuild;
    }
    public static InformacionLaboralBuilder infoLaboralPorDefecto() {
        return new InformacionLaboralBuilder();
    }

    public InformacionLaboralBuilder conProyecto(String proyecto) {
        this.proyectoBuild=proyecto;
        return this;
    }
    public InformacionLaboralBuilder isDiaHabil(Boolean diaHabil){
        this.diaHabilBuild=diaHabil;
        return  this;
    }
    public InformacionLaboralBuilder conTipoHora(String tipoH) {
        this.tipoHoraBuild=tipoH;
        return this;
    }

    public InformacionLaboralBuilder conServicio(String servicio) {
        this.servicioBuild=servicio;
        return this;
    }

    public InformacionLaboralBuilder conActividad(String actividad) {
        this.actividadBuild=actividad;
        return this;
    }

    public InformacionLaboralBuilder conHoraEjecutada(String horaEjecutada) {
        this.horaEjecutadaBuild=horaEjecutada;
        return this;
    }

    public InformacionLaboralBuilder conFecha(String fecha) {
        this.fechaBuild=fecha;
        return this;
    }

    public String getProyectoBuild() {
        return proyectoBuild;
    }

    public String getTipoHoraBuild() {
        return tipoHoraBuild;
    }

    public String getServicioBuild() {
        return servicioBuild;
    }

    public String getActividadBuild() {
        return actividadBuild;
    }

    public String getHoraEjecutadaBuild() {
        return horaEjecutadaBuild;
    }

    public String getComentarioBuild() {
        return comentarioBuild;
    }

    public String getFechaBuild() {
        return fechaBuild;
    }

    @Override
    public InformacionLaboral build() {
        return new InformacionLaboral (this);
    }
}
