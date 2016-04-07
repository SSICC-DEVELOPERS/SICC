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

package es.indra.sicc.dtos.cra;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;
/**
 * Sistema:       Belcorp
 * Modulo:        CRA - Cronograma de Actividades
 * Componente:    DTOActividad 
 * Fecha:         05/11/2003
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Nicolas Rodriguez Minetti
 */
 
public class DTOActividadesEliminar extends DTOAuditableSICC {
  private Vector oidsActividades;

  public DTOActividadesEliminar () { }

  public Vector getOidsActividades() {
    return oidsActividades;
  }

  public void setOidsActividades(Vector newOidsActividades) {
    oidsActividades = newOidsActividades;
  }
}
