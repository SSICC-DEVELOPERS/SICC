

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
 */
package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;
import es.indra.sicc.dtos.car.DTOReevaluar;

public class DTOTipoReevaluacion extends DTOReevaluar
{
  public Long[] tiposReevaluacion;
  public String codCliente;

  public DTOTipoReevaluacion()
  {
  }

  public Long[] getTiposReevaluacion()
  {
    return tiposReevaluacion;
  }

  public void setTiposReevaluacion(Long[] tiposReevaluacion)
  {
    this.tiposReevaluacion = tiposReevaluacion;
  }

  public String getCodCliente()
  {
    return codCliente;
  }

  public void setCodCliente(String codCliente)
  {
    this.codCliente = codCliente;
  }
}