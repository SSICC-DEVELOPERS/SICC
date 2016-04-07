package es.indra.sicc.dtos.ccc;
import es.indra.sicc.util.DTOBelcorp;

/**
 * Autor:  SCS
 * Fecha:  10/10/2006
 * Notas:
 */
public class DTOAbonoSubprocesoMarcaSituacion extends DTOBelcorp  {
  
  private Long oid;
  private Long oidTipoSolicitud;
  
  
  private Long oidProcesoCreacionCtas;
  private Long oidSubprocesoCreacionCtas;

  private Long oidProcesoAplicacionCtas;
  private Long oidSubprocesoAplicacionCtas;

  private Long oidCtaCteBancaria;
  
  public DTOAbonoSubprocesoMarcaSituacion() {
  }


  public void setOid(Long oid) {
    this.oid = oid;
  }


  public Long getOid() {
    return oid;
  }


  public void setOidTipoSolicitud(Long oidTipoSolicitud) {
    this.oidTipoSolicitud = oidTipoSolicitud;
  }


  public Long getOidTipoSolicitud() {
    return oidTipoSolicitud;
  }


  public void setOidProcesoCreacionCtas(Long oidProcesoCreacionCtas) {
    this.oidProcesoCreacionCtas = oidProcesoCreacionCtas;
  }


  public Long getOidProcesoCreacionCtas() {
    return oidProcesoCreacionCtas;
  }

  public void setOidSubprocesoCreacionCtas(Long oidSubprocesoCreacionCtas) {
    this.oidSubprocesoCreacionCtas = oidSubprocesoCreacionCtas;
  }


  public Long getOidSubprocesoCreacionCtas() {
    return oidSubprocesoCreacionCtas;
  }

  public void setOidProcesoAplicacionCtas(Long oidProcesoAplicacionCtas) {
    this.oidProcesoAplicacionCtas = oidProcesoAplicacionCtas;
  }


  public Long getOidProcesoAplicacionCtas() {
    return oidProcesoAplicacionCtas;
  }

  public void setOidSubprocesoAplicacionCtas(Long oidSubprocesoAplicacionCtas) {
    this.oidSubprocesoAplicacionCtas = oidSubprocesoAplicacionCtas;
  }


  public Long getOidSubprocesoAplicacionCtas() {
    return oidSubprocesoAplicacionCtas;
  }


  public void setOidCtaCteBancaria(Long oidCtaCteBancaria) {
    this.oidCtaCteBancaria = oidCtaCteBancaria;
  }

  public Long getOidCtaCteBancaria() {
    return oidCtaCteBancaria;
  }

}