/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DTODescuentosIncentivos extends DTOBelcorp
{
  private Long oidCliente;
  private Long oidMarca;
  private Long oidCanal;
  private Long[] oidAcceso;
  private Long oidPeriodoInicial;
  private Long oidPeriodoFinal;
  private BigDecimal porcentaje;
  private BigDecimal importe;
  private Boolean indComunicacionAutomatica;
  private ArrayList productos;

  public DTODescuentosIncentivos()
  {
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente)
  {
    this.oidCliente = oidCliente;
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

  public Long[] getOidAcceso()
  {
    return oidAcceso;
  }

  public void setOidAcceso(Long[] oidAcceso)
  {
    this.oidAcceso = oidAcceso;
  }

  public Long getOidPeriodoInicial()
  {
    return oidPeriodoInicial;
  }

  public void setOidPeriodoInicial(Long oidPeriodoInicial)
  {
    this.oidPeriodoInicial = oidPeriodoInicial;
  }

  public Long getOidPeriodoFinal()
  {
    return oidPeriodoFinal;
  }

  public void setOidPeriodoFinal(Long oidPeriodoFinal)
  {
    this.oidPeriodoFinal = oidPeriodoFinal;
  }

  public BigDecimal getPorcentaje()
  {
    return porcentaje;
  }

  public void setPorcentaje(BigDecimal porcentaje)
  {
    this.porcentaje = porcentaje;
  }

  public BigDecimal getImporte()
  {
    return importe;
  }

  public void setImporte(BigDecimal importe)
  {
    this.importe = importe;
  }

  public Boolean getIndComunicacionAutomatica()
  {
    return indComunicacionAutomatica;
  }

  public void setIndComunicacionAutomatica(Boolean indComunicacionAutomatica)
  {
    this.indComunicacionAutomatica = indComunicacionAutomatica;
  }
  
  public ArrayList getProductos()
  {
    return productos;
  }

  public void setProductos(ArrayList productos)
  {
    this.productos = productos;
  }  
}