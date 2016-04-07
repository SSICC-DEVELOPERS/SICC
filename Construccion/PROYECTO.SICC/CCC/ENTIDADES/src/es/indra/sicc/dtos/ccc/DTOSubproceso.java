package es.indra.sicc.dtos.ccc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOSubproceso extends DTOBelcorp  {
  Long oidSubproceso;
  Long oidProceso;
  Integer codSubproceso;
  String desSubproceso;
  Boolean indGestionMarcas;
  Long indActualizaCuota;
  Boolean indTipoAbono;
  String indConsultas;
  String observaciones;

  public DTOSubproceso() {
  }

  public Long getOidSubproceso() {
    return oidSubproceso;
  }

  public void setOidSubproceso(Long oidSubproceso) {
    this.oidSubproceso = oidSubproceso;
  }

  public Long getOidProceso() {
    return oidProceso;
  }

  public void setOidProceso(Long oidProceso) {
    this.oidProceso = oidProceso;
  }

  public Integer getCodSubproceso() {
    return codSubproceso;
  }

  public void setCodSubproceso(Integer codSubproceso) {
    this.codSubproceso = codSubproceso;
  }

  public String getDesSubproceso() {
    return desSubproceso;
  }

  public void setDesSubproceso(String desSubproceso) {
    this.desSubproceso = desSubproceso;
  }

  public Boolean getIndGestionMarcas() {
    return indGestionMarcas;
  }

  public void setIndGestionMarcas(Boolean indGestionMarcas) {
    this.indGestionMarcas = indGestionMarcas;
  }

  public Long getIndActualizaCuota() {
    return indActualizaCuota;
  }

  public void setIndActualizaCuota(Long indActualizaCuota) {
    this.indActualizaCuota = indActualizaCuota;
  }

  public Boolean getIndTipoAbono() {
    return indTipoAbono;
  }

  public void setIndTipoAbono(Boolean indTipoAbono) {
    this.indTipoAbono = indTipoAbono;
  }

  public String getIndConsultas() {
    return indConsultas;
  }

  public void setIndConsultas(String indConsultas) {
    this.indConsultas = indConsultas;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }
}