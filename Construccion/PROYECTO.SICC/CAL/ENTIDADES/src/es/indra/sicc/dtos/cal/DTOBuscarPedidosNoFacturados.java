package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarPedidosNoFacturados extends DTOSiccPaginacion {
  private Long oidPeriodoCorpo;
  private Long oidCliente;
 
  
  public DTOBuscarPedidosNoFacturados() { }
  
  public void setOidPeriodoCorpo(Long newOidPeriodoCorpo) {
    this.oidPeriodoCorpo = newOidPeriodoCorpo;
  }
  
  public Long getOidPeriodoCorpo() {
    return this.oidPeriodoCorpo;
  } 

  /** Incidencia BELC300022702
   *  Se agrega el atributo oidCliente,
   *  en DTOBuscarPedidosNoFacturados, de tipo Long.
   */
  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
  }
}