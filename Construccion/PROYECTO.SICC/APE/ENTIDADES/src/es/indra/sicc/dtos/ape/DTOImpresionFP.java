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
import java.util.Date;

public class DTOImpresionFP extends DTOSiccPaginacion {
  private Long oidCentroDistribucion;
  private Long oidLineaArmado;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidRegion;
  private Long oidZona;
  private Long oidSeccion;
  private Date fecha;

  public Long getOidCentroDistribucion()
  {
    return oidCentroDistribucion;
  }

  public void setOidCentroDistribucion(Long oidCentroDistribucion)
  {
    this.oidCentroDistribucion = oidCentroDistribucion;
  }

  public Long getOidLineaArmado()
  {
    return oidLineaArmado;
  }

  public void setOidLineaArmado(Long oidLineaArmado)
  {
    this.oidLineaArmado = oidLineaArmado;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }

  public Date getFecha()
  {
    return fecha;
  }

  public void setFecha(Date fecha)
  {
    this.fecha = fecha;
  }

}