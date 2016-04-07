package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Date;

public class DTOCabecera extends DTOAuditableSICC {
    private Long oidCabecera;
    private String codBuzon;
    private String idUsuario;
    private String descripcion; 


  public DTOCabecera() {  }

  public Long getOidCabecera() {
    return this.oidCabecera;  
  }
  
  public void setOidCabecera(Long newOidCabecera) {
    this.oidCabecera = newOidCabecera;
  }
  
  public String getCodBuzon() {
    return this.codBuzon;
  }
  
  public void setCodBuzon(String newCodBuzon) {
    this.codBuzon = newCodBuzon;
  }
  
  public String getIdUsuario() {
    return this.idUsuario;
  }
  
  public void setIdUsuario(String newIdUsuario) {
    this.idUsuario = newIdUsuario;
  }
  
  public String getDescripcion() {
    return this.descripcion;
  }
  
  public void setDescripcion(String newDescripcion) {
    this.descripcion = newDescripcion;
  }
}