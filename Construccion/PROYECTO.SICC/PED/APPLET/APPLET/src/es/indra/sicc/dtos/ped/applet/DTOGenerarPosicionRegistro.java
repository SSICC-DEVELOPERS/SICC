package es.indra.sicc.dtos.ped.applet;

import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOGenerarPosicionRegistro extends DTOAuditableSICC {
  private DTOCabeceraSolicitud cabeceraSolicitud;
  private Long cantidadReservar;
  private String numeroMovimiento;
  private Long controlStock;

  public DTOCabeceraSolicitud getCabeceraSolicitud()
  {
    return cabeceraSolicitud;
  }

  public void setCabeceraSolicitud(DTOCabeceraSolicitud cabeceraSolicitud)
  {
    this.cabeceraSolicitud = cabeceraSolicitud;
  }

  public Long getCantidadReservar()
  {
    return cantidadReservar;
  }

  public void setCantidadReservar(Long cantidadReservar)
  {
    this.cantidadReservar = cantidadReservar;
  }

  public String getNumeroMovimiento()
  {
    return numeroMovimiento;
  }

  public void setNumeroMovimiento(String numeroMovimiento)
  {
    this.numeroMovimiento = numeroMovimiento;
  }

  public Long getControlStock()
  {
    return controlStock;
  }

  public void setControlStock(Long controlStock)
  {
    this.controlStock = controlStock;
  }
}