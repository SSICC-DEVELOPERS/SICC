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
 * Autor Marta Aurora Montiel
 * Fecha 23/03/05
 * Incidencia BELC300014887
 */

package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOPrecioReclamo extends DTOBelcorp
{
  public DTOPrecioReclamo(){}
  
  private Long oidConcurso;
  private String codigoVenta;
  private BigDecimal precioPublico;  
    private Long oidProducto;

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public String getCodigoVenta()
  {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta)
  {
    this.codigoVenta = codigoVenta;
  }

  public BigDecimal getPrecioPublico()
  {
    return precioPublico;
  }

  public void setPrecioPublico(BigDecimal precioPublico)
  {
    this.precioPublico = precioPublico;
  }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }
  
  
}