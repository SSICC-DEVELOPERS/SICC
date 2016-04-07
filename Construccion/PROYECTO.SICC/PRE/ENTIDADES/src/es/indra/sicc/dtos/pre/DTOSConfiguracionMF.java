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
import es.indra.mare.common.mii.services.jdbcservice.*;

public class DTOSConfiguracionMF extends DTOAuditableSICC 
{
  private Long oidConfiguracionMF;
  private Long oidMoneda;
  private String descripcionMoneda;
  private Long oidMonedaAlternativa;
  //private RecordSet monedas;
  
  public DTOSConfiguracionMF()
  {
  }

  /*public RecordSet getMonedas()
  {
    return monedas;
  }

  public void setMonedas(RecordSet newMonedas)
  {
    monedas = newMonedas;
  }*/

  public Long getOidConfiguracionMF()
  {
    return oidConfiguracionMF;
  }

  public void setOidConfiguracionMF(Long newOidConfiguracionMF)
  {
    oidConfiguracionMF = newOidConfiguracionMF;
  }

  public Long getOidMoneda()
  {
    return oidMoneda;
  }

  public void setOidMoneda(Long newOidMoneda)
  {
    oidMoneda = newOidMoneda;
  }

  public String getDescripcionMoneda() {
    return descripcionMoneda;
  }

  public void setDescripcionMoneda(String newDescripcionMoneda) {
    descripcionMoneda = newDescripcionMoneda;
  }

  public Long getOidMonedaAlternativa() {
    return oidMonedaAlternativa;
  }

  public void setOidMonedaAlternativa(Long newOidMonedaAlternativa) {
    oidMonedaAlternativa = newOidMonedaAlternativa;
  }
}