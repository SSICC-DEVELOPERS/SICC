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


package es.indra.sicc.dtos.ccc;

import es.indra.sicc.util.DTOBelcorp;

public class DTOParametrosCuotasCancelacion extends DTOBelcorp {

  private Integer numeroIdentificacion;
  private String indEmisionVto;
  private Long tipoAbonoUltimo;
  private Long marcaSituacion;
  private Long oidSubproceso2CCC002;
  private Long marcasEntrada[];
  private Long cuentaContableCCC002;

  public DTOParametrosCuotasCancelacion()
  {
  }

  public void setNumeroIdentificacion(Integer numeroIdentificacion)
  {
    this.numeroIdentificacion = numeroIdentificacion;
  }

  public Integer getNumeroIdentificacion()
  {
    return numeroIdentificacion;
  }

  public void setIndEmisionVto(String indEmisionVto)
  {
    this.indEmisionVto = indEmisionVto;
  }

  public String getIndEmisionVto()
  {
    return indEmisionVto;
  }

  public void setTipoAbonoUltimo(Long tipoAbonoUltimo)
  {
    this.tipoAbonoUltimo = tipoAbonoUltimo;
  }

  public Long getTipoAbonoUltimo()
  {
    return tipoAbonoUltimo;
  }

  public void setMarcaSituacion(Long marcaSituacion)
  {
    this.marcaSituacion = marcaSituacion;
  }

  public Long getMarcaSituacion()
  {
    return marcaSituacion;
  }

  public void setOidSubproceso2CCC002(Long oidSubproceso2CCC002)
  {
    this.oidSubproceso2CCC002 = oidSubproceso2CCC002;
  }

  public Long getOidSubproceso2CCC002()
  {
    return oidSubproceso2CCC002;
  }

  public void setMarcasEntrada(Long[] marcasEntrada)
  {
    this.marcasEntrada = marcasEntrada;
  }

  public Long[] getMarcasEntrada()
  {
    return marcasEntrada;
  }

  public void setCuentaContableCCC002(Long cuentaContableCCC002)
  {
    this.cuentaContableCCC002 = cuentaContableCCC002;
  }

  public Long getCuentaContableCCC002()
  {
    return cuentaContableCCC002;
  }
}