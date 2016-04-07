package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajeTipoCliente extends DTOAuditableSICC{
  private Long oid;
  private Long oidTipoCliente;
  private Long oidSubtipoCliente;
  private Long oidTipoClasificacion;
  private Long oidClasificacion;
  private DTODestinatario tipoCliente;
  // Agregado por HRCS - Fecha 24/05/2007 - Incidencia Sicc20070203
  private String oidsTipoClasificaciones;
  private String oidsClasificaciones;

  public Long getOid(){
    return oid;
  }

  public void setOid(Long newOid){
    oid = newOid;
  }

  public Long getOidTipoCliente(){
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long newOidTipoCliente){
    oidTipoCliente = newOidTipoCliente;
  }

  public Long getOidSubtipoCliente(){
    return oidSubtipoCliente;
  }

  public void setOidSubtipoCliente(Long newOidSubtipoCliente){
    oidSubtipoCliente = newOidSubtipoCliente;
  }

  public Long getOidTipoClasificacion(){
    return oidTipoClasificacion;
  }

  public void setOidTipoClasificacion(Long newOidTipoClasificacion){
    oidTipoClasificacion = newOidTipoClasificacion;
  }

  public Long getOidClasificacion(){
    return oidClasificacion;
  }

  public void setOidClasificacion(Long newOidClasificacion){
    oidClasificacion = newOidClasificacion;
  }

  public DTODestinatario getTipoCliente(){
    return tipoCliente;
  }

  public void setTipoCliente(DTODestinatario newTipoCliente) {
    tipoCliente = newTipoCliente;
  }


    public void setOidsTipoClasificaciones(String oidsTipoClasificaciones) {
        this.oidsTipoClasificaciones = oidsTipoClasificaciones;
    }


    public String getOidsTipoClasificaciones() {
        return oidsTipoClasificaciones;
    }


    public void setOidsClasificaciones(String oidsClasificaciones) {
        this.oidsClasificaciones = oidsClasificaciones;
    }


    public String getOidsClasificaciones() {
        return oidsClasificaciones;
    }

  
}