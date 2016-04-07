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
 *
 */
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOECabeceraMF extends DTOAuditableSICC 
{
  private Long oid;
  private Long oidMarca;
  private Long oidCanal;
  private Long oidPeriodo;
  private Long numeroPedidosEstimado;
  private Long unidadesEstimadas;
  private Long clientesEstimados;

  //valorEstimado paso a llamarse totalMontoVentaNeta por cambio en disenio.
  private Long totalMontoVentaNeta; 

  //tipoCambio paso a llamarse tipoCambioPromedioPeriodo por cambio en disenio.
  private Double tipoCambioPromedioPeriodo;
  
  private Boolean registroEstadisticoGenerado;
  private Boolean matrizFacturada;
  private Boolean matrizGenerada;

  public DTOECabeceraMF()
  {
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long newOid)
  {
    oid = newOid;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long newOidMarca)
  {
    oidMarca = newOidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long newOidCanal)
  {
    oidCanal = newOidCanal;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long newOidPeriodo)
  {
    oidPeriodo = newOidPeriodo;
  }

  public Long getNumeroPedidosEstimado()
  {
    return numeroPedidosEstimado;
  }

  public void setNumeroPedidosEstimado(Long newNumeroPedidosEstimado)
  {
    numeroPedidosEstimado = newNumeroPedidosEstimado;
  }

  public Long getUnidadesEstimadas()
  {
    return unidadesEstimadas;
  }

  public void setUnidadesEstimadas(Long newUnidadesEstimadas)
  {
    unidadesEstimadas = newUnidadesEstimadas;
  }

  public Long getClientesEstimados()
  {
    return clientesEstimados;
  }

  public void setClientesEstimados(Long newClientesEstimados)
  {
    clientesEstimados = newClientesEstimados;
  }

  public Long getTotalMontoVentaNeta()
  {
    return totalMontoVentaNeta;
  }

  public void setTotalMontoVentaNeta(Long newValorEstimado)
  {
    totalMontoVentaNeta = newValorEstimado;
  }

  public Double getTipoCambioPromedioPeriodo()
  {
    return tipoCambioPromedioPeriodo;
  }

  public void setTipoCambioPromedioPeriodo(Double newTipoCambio)
  {
    tipoCambioPromedioPeriodo = newTipoCambio;
  }

  public Boolean getRegistroEstadisticoGenerado()
  {
    return registroEstadisticoGenerado;
  }

  public void setRegistroEstadisticoGenerado(Boolean newRegistroEstadisticoGenerado)
  {
    registroEstadisticoGenerado = newRegistroEstadisticoGenerado;
  }

  public Boolean getMatrizFacturada()
  {
    return matrizFacturada;
  }

  public void setMatrizFacturada(Boolean newMatrizFacturada)
  {
    matrizFacturada = newMatrizFacturada;
  }

  public Boolean getMatrizGenerada()
  {
    return matrizGenerada;
  }

  public void setMatrizGenerada(Boolean newMatrizGenerada)
  {
    matrizGenerada = newMatrizGenerada;
  }
}