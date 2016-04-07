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
 
package es.indra.sicc.dtos.bel;

import java.math.BigDecimal;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOCargaCobroBelcenter extends DTOAuditableSICC
{
  private DTOCargaMedioPago[] medioPago;
  private DTOCargaMoneda moneda;
  private BigDecimal tipoCambio;
  private DTODatosCombo[] banco;
  private DTODatosCombo[] tipoTarjeta;

  public DTOCargaCobroBelcenter()
  {
  }

  public DTOCargaMedioPago[] getMedioPago()
  {
    return medioPago;
  }

  public void setMedioPago(DTOCargaMedioPago[] medioPago)
  {
    this.medioPago = medioPago;
  }

  public DTOCargaMoneda getMoneda()
  {
    return moneda;
  }

  public void setMoneda(DTOCargaMoneda moneda)
  {
    this.moneda = moneda;
  }

  public BigDecimal getTipoCambio()
  {
    return tipoCambio;
  }

  public void setTipoCambio(BigDecimal tipoCambio)
  {
    this.tipoCambio = tipoCambio;
  }

  public DTODatosCombo[] getBanco()
  {
    return banco;
  }

  public void setBanco(DTODatosCombo[] banco)
  {
    this.banco = banco;
  }

  public DTODatosCombo[] getTipoTarjeta()
  {
    return tipoTarjeta;
  }

  public void setTipoTarjeta(DTODatosCombo[] tipoTarjeta)
  {
    this.tipoTarjeta = tipoTarjeta;
  }
}