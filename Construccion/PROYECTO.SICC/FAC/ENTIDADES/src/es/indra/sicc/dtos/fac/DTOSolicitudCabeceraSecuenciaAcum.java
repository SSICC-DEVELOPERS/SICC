package es.indra.sicc.dtos.fac;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOSolicitudCabeceraSecuenciaAcum extends DTOBelcorp  {


  Date fechaFacturacion;
  Long numSecuenciaZonaRuta;
  Long numSecuenciaFacturacionDiariaAcum;
  Boolean indicadorUpdate;

  public DTOSolicitudCabeceraSecuenciaAcum() {
  }

  public Date getFechaFacturacion() {
    return fechaFacturacion;
  }

  public void setFechaFacturacion(Date fechaFacturacion) {
    this.fechaFacturacion = fechaFacturacion;
  }

  public Long getNumSecuenciaZonaRuta() {
    return numSecuenciaZonaRuta;
  }

  public void setNumSecuenciaZonaRuta(Long numSecuenciaZonaRuta) {
    this.numSecuenciaZonaRuta = numSecuenciaZonaRuta;
  }

  public Long getNumSecuenciaFacturacionDiariaAcum() {
    return numSecuenciaFacturacionDiariaAcum;
  }

  public void setNumSecuenciaFacturacionDiariaAcum(Long numSecuenciaFacturacionDiariaAcum) {
    this.numSecuenciaFacturacionDiariaAcum = numSecuenciaFacturacionDiariaAcum;
  }

  public Boolean getIndicadorUpdate() {
    return indicadorUpdate;
  }

  public void setIndicadorUpdate(Boolean indicadorUpdate) {
    this.indicadorUpdate = indicadorUpdate;
  }


}