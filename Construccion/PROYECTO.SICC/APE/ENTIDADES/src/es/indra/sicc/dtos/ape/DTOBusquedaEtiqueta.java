/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */

package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBusquedaEtiqueta extends DTOSiccPaginacion {
  private Long oidSolicCabec;
  private Long nroSolicCabec;
  private Integer nroCaja;
  private Boolean impresa;

  public Long getOidSolicCabec()
  {
    return oidSolicCabec;
  }

  public void setOidSolicCabec(Long oidSolicCabec)
  {
    this.oidSolicCabec = oidSolicCabec;
  }

  public Long getNroSolicCabec()
  {
    return nroSolicCabec;
  }

  public void setNroSolicCabec(Long nroSolicCabec)
  {
    this.nroSolicCabec = nroSolicCabec;
  }

  public Integer getNroCaja()
  {
    return nroCaja;
  }

  public void setNroCaja(Integer nroCaja)
  {
    this.nroCaja = nroCaja;
  }

  public Boolean getImpresa()
  {
    return impresa;
  }

  public void setImpresa(Boolean impresa)
  {
    this.impresa = impresa;
  }

  

}