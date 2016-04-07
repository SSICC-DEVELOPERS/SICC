/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOObtenerSolicitudCobro extends DTOAuditableSICC
{
  private Long oidSubacceso;
  private String numeroSolicitud;
  private BigDecimal importe;
  private BigDecimal importeDivisa;
  private Long oidSolicitud;
  private Long oidMoneda;
  private BigDecimal totalPagarLocal;
  private BigDecimal totalPagarDocumento;

  public DTOObtenerSolicitudCobro()
  {
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public String getNumeroSolicitud()
  {
    return numeroSolicitud;
  }

  public void setNumeroSolicitud(String numeroSolicitud)
  {
    this.numeroSolicitud = numeroSolicitud;
  }

  public BigDecimal getImporte()
  {
    return importe;
  }

  public void setImporte(BigDecimal importe)
  {
    this.importe = importe;
  }

  public BigDecimal getImporteDivisa()
  {
    return importeDivisa;
  }

  public void setImporteDivisa(BigDecimal importeDivisa)
  {
    this.importeDivisa = importeDivisa;
  }

  public Long getOidSolicitud()
  {
    return oidSolicitud;
  }

  public void setOidSolicitud(Long oidSolicitud)
  {
    this.oidSolicitud = oidSolicitud;
  }

  public Long getOidMoneda()
  {
    return oidMoneda;
  }

  public void setOidMoneda(Long oidMoneda)
  {
    this.oidMoneda = oidMoneda;
  }

  public BigDecimal getTotalPagarLocal()
  {
    return totalPagarLocal;
  }

  public void setTotalPagarLocal(BigDecimal totalPagarLocal)
  {
    this.totalPagarLocal = totalPagarLocal;
  }

  public BigDecimal getTotalPagarDocumento()
  {
    return totalPagarDocumento;
  }

  public void setTotalPagarDocumento(BigDecimal totalPagarDocumento)
  {
    this.totalPagarDocumento = totalPagarDocumento;
  }
}