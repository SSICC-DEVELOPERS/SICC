package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajeCliente extends DTOAuditableSICC{
  private Long oid;
  private Long oidCliente;
  private DTODestinatario cliente;

  public Long getOid(){
    return oid;
  }

  public void setOid(Long newOid){
    oid = newOid;
  }

  public Long getOidCliente(){
    return oidCliente;
  }

  public void setOidCliente(Long newOidCliente){
    oidCliente = newOidCliente;
  }

  public DTODestinatario getCliente(){
    return cliente;
  }

  public void setCliente(DTODestinatario newCliente) {
    cliente = newCliente;
  }
}