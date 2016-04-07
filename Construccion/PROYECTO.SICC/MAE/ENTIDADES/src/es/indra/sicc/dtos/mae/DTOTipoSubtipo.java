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
 */

package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


/**
 * Sistema:       Belcorp
 * Modulo:           MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:             11/12/2003
 * Observaciones: 
 *
 *
 *
 *
 * @author Luciana C. Garcia Mari
 * @version 1.0
 */
public class DTOTipoSubtipo extends DTOAuditableSICC {
  private RecordSet tipos;
  private RecordSet subtipos;

    /**
     * Construye un DTOTipoSubtipo
     */
    public DTOTipoSubtipo() {
    }

  public RecordSet getTipos() {
    return tipos;
  }

  public void setTipos(RecordSet newTipos) {
    tipos = newTipos;
  }

  public RecordSet getSubtipos() {
    return subtipos;
  }

  public void setSubtipos(RecordSet newSubtipos) {
    subtipos = newSubtipos;
  }
}
