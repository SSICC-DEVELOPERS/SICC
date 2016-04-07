/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.intsys;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOParametrosContablesFAC extends DTOSiccPaginacion {
  private Long oid;
  private String codApunte;
  private String tipoAsiento;
  private String cabeceraDetalle;
  private String descripcion;
  private String grupoProductos;
  private Long marcaProductos;
  private Long negocio;
  private String codProductoSAP;
  private Long cuentaContable;
  private String debeHaber;
  private Long codImporte;

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }

  public String getCodApunte()
  {
    return codApunte;
  }

  public void setCodApunte(String codApunte)
  {
    this.codApunte = codApunte;
  }

  public String getTipoAsiento()
  {
    return tipoAsiento;
  }

  public void setTipoAsiento(String tipoAsiento)
  {
    this.tipoAsiento = tipoAsiento;
  }

  public String getCabeceraDetalle()
  {
    return cabeceraDetalle;
  }

  public void setCabeceraDetalle(String cabeceraDetalle)
  {
    this.cabeceraDetalle = cabeceraDetalle;
  }

  public String getDescripcion()
  {
    return descripcion;
  }

  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }

  public String getGrupoProductos()
  {
    return grupoProductos;
  }

  public void setGrupoProductos(String grupoProductos)
  {
    this.grupoProductos = grupoProductos;
  }

  public Long getMarcaProductos()
  {
    return marcaProductos;
  }

  public void setMarcaProductos(Long marcaProductos)
  {
    this.marcaProductos = marcaProductos;
  }

  public Long getNegocio()
  {
    return negocio;
  }

  public void setNegocio(Long negocio)
  {
    this.negocio = negocio;
  }

  public String getCodProductoSAP()
  {
    return codProductoSAP;
  }

  public void setCodProductoSAP(String codProductoSAP)
  {
    this.codProductoSAP = codProductoSAP;
  }

  public Long getCuentaContable()
  {
    return cuentaContable;
  }

  public void setCuentaContable(Long cuentaContable)
  {
    this.cuentaContable = cuentaContable;
  }

  public String getDebeHaber()
  {
    return debeHaber;
  }

  public void setDebeHaber(String debeHaber)
  {
    this.debeHaber = debeHaber;
  }

  public Long getCodImporte()
  {
    return codImporte;
  }

  public void setCodImporte(Long codImporte)
  {
    this.codImporte = codImporte;
  }


}