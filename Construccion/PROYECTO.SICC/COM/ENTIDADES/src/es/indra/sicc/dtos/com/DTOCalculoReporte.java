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
 * Autor: Viviana Bongiovanni
 */
package es.indra.sicc.dtos.com;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DTOCalculoReporte extends DTOBelcorp {
  private BigDecimal importePagado;
  private ArrayList cuota;

  public DTOCalculoReporte() {
  }

  public BigDecimal getImportePagado() {
    return importePagado;
  }

  public void setImportePagado(BigDecimal importePagado) {
    this.importePagado = importePagado;
  }

  public ArrayList getCuota() {
    return cuota;
  }

  public void setCuota(ArrayList cuota) {
    this.cuota = cuota;
  }
}