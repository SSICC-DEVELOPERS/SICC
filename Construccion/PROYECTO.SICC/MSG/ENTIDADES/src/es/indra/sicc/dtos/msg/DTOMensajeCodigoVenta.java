package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajeCodigoVenta extends DTOAuditableSICC{
  private Long oid;
  private String codigoVenta;
  
  public Long getOid(){
    return oid;
  }

  public void setOid(Long newOid){
    oid = newOid;
  }

  public String getCodigoVenta(){
    return codigoVenta;
  }

  public void setCodigoVenta(String newCodigoVenta){
    codigoVenta = newCodigoVenta;
  }

 
}