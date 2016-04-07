package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTipificacionCliente extends DTOAuditableSICC  {

    private Long oidCliente;
    private Long oidTipoCliente;
    private Long oidSubtipoCliente;
    private Long oidTipoClasificacionCliente;
    private Long oidClasificacionCliente;

    public DTOTipificacionCliente() {
    }
  
    public void setOidCliente(Long oidCliente) {
      this.oidCliente = oidCliente;
    }
  
    public Long getOidCliente() {
      return oidCliente;
    }
  
    public void setOidTipoCliente(Long oidTipoCliente) {
      this.oidTipoCliente = oidTipoCliente;
    }
  
    public Long getOidTipoCliente() {
      return oidTipoCliente;
    }
  
    public void setOidSubtipoCliente(Long oidSubtipoCliente) {
      this.oidSubtipoCliente = oidSubtipoCliente;
    }
  
    public Long getOidSubtipoCliente() {
      return oidSubtipoCliente;
    }
  
    public void setOidTipoClasificacionCliente(Long oidTipoClasificacionCliente) {
      this.oidTipoClasificacionCliente = oidTipoClasificacionCliente;
    }
  
    public Long getOidTipoClasificacionCliente() {
      return oidTipoClasificacionCliente;
    }
  
    public void setOidClasificacionCliente(Long oidClasificacionCliente) {
      this.oidClasificacionCliente = oidClasificacionCliente;
    }
  
    public Long getOidClasificacionCliente(){
      return oidClasificacionCliente;
    }     
        
}