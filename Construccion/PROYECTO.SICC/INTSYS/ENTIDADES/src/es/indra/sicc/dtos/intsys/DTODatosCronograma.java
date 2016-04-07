package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTODatosCronograma extends DTOBelcorp  {
  private String codZona;
  private String codActividad;
  private Date fechaFin;
  private String indicadorFecha;
    private String claseActividad;

  public DTODatosCronograma() {
  }

  public String getCodZona() {
    return codZona;
  }

  public void setCodZona(String codZona) {
    this.codZona = codZona;
  }

  public String getCodActividad() {
    return codActividad;
  }

  public void setCodActividad(String codActividad) {
    this.codActividad = codActividad;
  }

  public Date getFechaFin() {
    return fechaFin;
  }

  public void setFechaFin(Date fechaFin) {
    this.fechaFin = fechaFin;
  }

  public String getIndicadorFecha() {
    return indicadorFecha;
  }

  public void setIndicadorFecha(String indicadorFecha) {
    this.indicadorFecha = indicadorFecha;
  }

    public String getClaseActividad() {
        return claseActividad;
    }

    public void setClaseActividad(String claseActividad) {
        this.claseActividad = claseActividad;
    }
}