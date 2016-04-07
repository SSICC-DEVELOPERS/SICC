package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajeMarca extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidMarca;
  private DTODestinatario marca;

  public Long getOid(){
    return oid;
  }

  public void setOid(Long newOid){
    oid = newOid;
  }

  public Long getOidMarca(){
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca){
    oidMarca = newOidMarca;
  }

  public DTODestinatario getMarca(){
    return marca;
  }

  public void setMarca(DTODestinatario newMarca) {
    marca = newMarca;
  }
}