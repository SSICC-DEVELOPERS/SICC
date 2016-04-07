package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;



public class DTOINTEnviarInfCliente extends DTOAuditableSICC 
{
  
  private Long numeroLote;
  private String descripcionLote;
  private String observaciones;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodo;  
  
  
  public DTOINTEnviarInfCliente()
  {
  }
  
 public void setNumeroLote(Long newNumeroLote) {
    this.numeroLote = newNumeroLote;
  }


  public Long getNumeroLote() {
    return numeroLote;
  }
  
  public String getDescripcionLote() {
     return descripcionLote;
  }

  public void setDescripcionLote(String newDescripcionLote){
      descripcionLote = newDescripcionLote;
  }

  public String getObservaciones() {
     return observaciones;
  }

  public void setObservaciones(String newObservaciones) {
     observaciones = newObservaciones;
  }

  public void setOidMarca(Long newOidMarca) {
    this.oidMarca = newOidMarca;
  }


  public Long getOidMarca() {
    return oidMarca;
  }
 


  public Long getOidCanal() {
    return oidCanal;
  }

  public void setOidCanal(Long newOidCanal) {
    this.oidCanal = newOidCanal;
  }


  public Long getOidPeriodo() {
    return oidPeriodo;
  }
  
  public void setOidPeriodo(Long newOidPeriodo) {
    this.oidPeriodo = newOidPeriodo;
  }

  
  
}