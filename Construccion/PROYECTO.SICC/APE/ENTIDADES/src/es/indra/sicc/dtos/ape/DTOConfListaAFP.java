package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOConfListaAFP extends DTOBelcorp  {
    private Long oidConfListaAFP;
    private Long nroLinea;
    private Long oidRegion;
    private Long oidZona;
    private Long oidSeccion;
    private Long agrupacion;

  public DTOConfListaAFP() {}


  public void setOidConfListaAFP(Long oidConfListaAFP) {
    this.oidConfListaAFP = oidConfListaAFP;
  }


  public Long getOidConfListaAFP() {
    return oidConfListaAFP;
  }


  public void setNroLinea(Long nroLinea) {
    this.nroLinea = nroLinea;
  }


  public Long getNroLinea() {
    return nroLinea;
  }


  public void setOidRegion(Long oidRegion) {
    this.oidRegion = oidRegion;
  }


  public Long getOidRegion() {
    return oidRegion;
  }


  public void setOidZona(Long oidZona) {
    this.oidZona = oidZona;
  }


  public Long getOidZona() {
    return oidZona;
  }


  public void setOidSeccion(Long oidSeccion) {
    this.oidSeccion = oidSeccion;
  }


  public Long getOidSeccion() {
    return oidSeccion;
  }


  public void setAgrupacion(Long agrupacion) {
    this.agrupacion = agrupacion;
  }


  public Long getAgrupacion() {
    return agrupacion;
  }
}