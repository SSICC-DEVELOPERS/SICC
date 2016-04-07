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

package es.indra.sicc.dtos.app;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOSolicitudCabeceraSecuenciaAcumulado extends DTOBelcorp {
  private Long oidZona;
  private Date fechaFacturacion;
  private Boolean indicadorUpdate;
  private Long numeroSecuenciaAcumulado;

  public Long getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long oidZona)
  {
    this.oidZona = oidZona;
  }

  public Date getFechaFacturacion()
  {
    return fechaFacturacion;
  }

  public void setFechaFacturacion(Date fechaFacturacion)
  {
    this.fechaFacturacion = fechaFacturacion;
  }

  public Boolean getIndicadorUpdate()
  {
    return indicadorUpdate;
  }

  public void setIndicadorUpdate(Boolean indicadorUpdate)
  {
    this.indicadorUpdate = indicadorUpdate;
  }

  public Long getNumeroSecuenciaAcumulado()
  {
    return numeroSecuenciaAcumulado;
  }

  public void setNumeroSecuenciaAcumulado(Long numeroSecuenciaAcumulado)
  {
    this.numeroSecuenciaAcumulado = numeroSecuenciaAcumulado;
  }


}