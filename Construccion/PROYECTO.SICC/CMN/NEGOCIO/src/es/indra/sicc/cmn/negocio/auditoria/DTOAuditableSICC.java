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
package es.indra.sicc.cmn.negocio.auditoria;

import javax.ejb.EntityBean;
import es.indra.sicc.util.DTOBelcorp;
/**
 * Sistema:           Belcorp
 * Modulo:            CMN
 * Componente:        DTOAuditableSICC
 * Fecha:             29/10/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes 
 * Descripcion:       DTOAuditableSICC
 * @version           1.0
 * @autor             Emilio Noziglia, Nicolas Rodriguez Minetti
 */
public class DTOAuditableSICC extends DTOBelcorp 
  {
  private String programa;
  private String ipCliente;

  public DTOAuditableSICC() {
    super();
  }

  public String getPrograma() {
    return programa;
  }

  public void setPrograma(String newPrograma) {
    programa = newPrograma;
  }

  public String getIpCliente() {
    return ipCliente;
  }

  public void setIpCliente(String newIpCliente) {
    ipCliente = newIpCliente;
  }
}