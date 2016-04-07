package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * 
 * @Autor Alem Joaquin
 * @Fecha 
 * @Descripcion 
 */
public class DTOCalculoPedidos extends  DTOAuditableSICC {
  /**
   * 
   * @Autor Alem Joaquin
   * @Fecha 
   * @Descripcion 
   */
   
   private Long oidCliente;
   private Long oidPeriodo1;
   private Long oidPeriodo2;   
   private Long oidClaseSolicitud;

   
   
   
  public DTOCalculoPedidos() {
  }


  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }


  public Long getOidCliente() {
    return oidCliente;
  }


  public void setOidPeriodo1(Long oidPeriodo1) {
    this.oidPeriodo1 = oidPeriodo1;
  }


  public Long getOidPeriodo1() {
    return oidPeriodo1;
  }


  public void setOidPeriodo2(Long oidPeriodo2) {
    this.oidPeriodo2 = oidPeriodo2;
  }


  public Long getOidPeriodo2() {
    return oidPeriodo2;
  }


  public void setOidClaseSolicitud(Long oidClaseSolicitud) {
    this.oidClaseSolicitud = oidClaseSolicitud;
  }


  public Long getOidClaseSolicitud() {
    return oidClaseSolicitud;
  }
}