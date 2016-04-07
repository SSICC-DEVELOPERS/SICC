package es.indra.sicc.dtos.ccc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOMarcasPorTipoAbono extends DTOSiccPaginacion {

  private Long oid;
  private String observaciones;
  private Long marcaSituacionSalida;
  private Long subproceso;
  private Long tipoAbono;
  private Long tipoAbonoSubproceso;
  private Long proceso;
  private Long[] marcasSituacionEntrada;

  public DTOMarcasPorTipoAbono() {}
  
  public Long getOid() {
    return oid; 
  }

  public void setOid(Long newOid) {  
    oid = newOid; 
  }

  public String getObservaciones() { 
    return observaciones; 
  }

  public void setObservaciones(String newObservaciones) {  
    observaciones = newObservaciones; 
  }

  public Long getMarcaSituacionSalida () {  
    return marcaSituacionSalida; 
  }

  public void setMarcaSituacionSalida(Long newMarcaSituacionSalida) { 
    marcaSituacionSalida = newMarcaSituacionSalida; 
  }

  public Long getSubproceso() { 
    return subproceso; 
  }

  public void setSubproceso(Long newSubproceso) { 
    subproceso = newSubproceso; 
  }

  public Long getTipoAbono() { 
    return tipoAbono; 
  }

  public void setTipoAbono(Long newTipoAbono) {
    tipoAbono = newTipoAbono; 
  }

  public Long getProceso() { 
    return proceso; 
  }

  public void setProceso(Long newProceso) { 
    proceso = newProceso; 
  }

  public Long[] getMarcasSituacionEntrada() { 
    return marcasSituacionEntrada; 
  }

  public void setMarcasSituacionEntrada(Long[] newMarcasSituacionEntrada) {
    marcasSituacionEntrada = newMarcasSituacionEntrada; 
  }  


   public void setTipoAbonoSubproceso(Long tipoAbonoSubproceso) {
      this.tipoAbonoSubproceso = tipoAbonoSubproceso;
   }


   public Long getTipoAbonoSubproceso() {
      return tipoAbonoSubproceso;
   }
}