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


/**
 * Sistema:       Belcorp
 * Modulo:           MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:             11/12/2003
 * Observaciones: 
 *
 *
 * @author Luciana C. Garcia Mari
 * @version 1.0
 */
public class DTOConfiguracionCampo extends DTOAuditableSICC {
  private Long campo;
  private Long subtipoCliente;
  private Boolean obligatorio;
  private Boolean modificable;
  private String valorDefecto;
  private Long oid;

    /**
     * Construye un DTOConfiguracionCampo
     */
    public DTOConfiguracionCampo() {
    }

  public Long getCampo() {
    return campo;
  }

  public void setCampo(Long newCampo) {
    campo = newCampo;
  }

  public Long getSubtipoCliente() {
    return subtipoCliente;
  }

  public void setSubtipoCliente(Long newSubtipoCliente) {
    subtipoCliente = newSubtipoCliente;
  }

  public Boolean getObligatorio() {
    return obligatorio;
  }

  public void setObligatorio(Boolean newObligatorio) {
    obligatorio = newObligatorio;
  }

  public Boolean getModificable() {
    return modificable;
  }

  public void setModificable(Boolean newModificable) {
    modificable = newModificable;
  }

  public String getValorDefecto() {
    return valorDefecto;
  }

  public void setValorDefecto(String newValorDefecto) {
    valorDefecto = newValorDefecto;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }
}
