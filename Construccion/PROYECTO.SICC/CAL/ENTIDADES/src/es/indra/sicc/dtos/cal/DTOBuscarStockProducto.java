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

package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarStockProducto extends DTOSiccPaginacion{
  public DTOBuscarStockProducto() 
  {
    super();
  }
  private Long oidMarca;  
  private Long oidCanal;  
  private Long oidPeriodo;     
  private Long oidAcceso;    
  private Long oidSubacceso;
  private Long oidAlmacen;    
  private String codProducto;     
  private String descProducto;    
  private String codVenta;    
  private Long oidRegion;    
  private Long oidZona;

  public String getCodProducto()
  {
    return codProducto;
  }

  public void setCodProducto(String codProducto)
  {
    this.codProducto = codProducto;
  }

  public String getCodVenta()
  {
    return codVenta;
  }

  public void setCodVenta(String codVenta)
  {
    this.codVenta = codVenta;
  }

  public String getDescProducto()
  {
    return descProducto;
  }

  public void setDescProducto(String descProducto)
  {
    this.descProducto = descProducto;
  }

  public Long getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidAlmacen()
  {
    return oidAlmacen;
  }

  public void setOidAlmacen(Long oidAlmacen)
  {
    this.oidAlmacen = oidAlmacen;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Long getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long getOidSubacceso()
  {
    return oidSubacceso;
  }

  public void setOidSubacceso(Long oidSubacceso)
  {
    this.oidSubacceso = oidSubacceso;
  }

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }
}