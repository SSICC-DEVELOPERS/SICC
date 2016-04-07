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
* Sistema:         Belcorp
 * Modulo:           MAE
 * Submódulo:     Mantenimiento de Materiales
 * Componente:    DTOConsultaConfiguracionCampos.java
 * Fecha:             10/12/2003      
 * Observaciones: 
 *
 * 
 * @author Luciana C. Garcia Mari
 * @version 1.0
 */
public class DTOConsultaConfiguracionCampos extends DTOAuditableSICC {
    private String  campo;
    private Boolean obligatorio;
    private Boolean modificable;
    private String  valorDefecto;
    private String  tipoCliente;
    private String  subtipoCliente;
    private Boolean indClienteProducto;

    /**
     * Construye un DTOConsultaConfiguracionCampos
     */
    public DTOConsultaConfiguracionCampos() {
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getCampo() {
        return campo;
    }

    /**
     * DOCUMENT ME!
     *
     * @param newCampo - DOCUMENT ME!
     */
    public void setCampo(String newCampo) {
        campo = newCampo;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Boolean getObligatorio() {
        return obligatorio;
    }

    /**
     * DOCUMENT ME!
     *
     * @param newObligatorio - DOCUMENT ME!
     */
    public void setObligatorio(Boolean newObligatorio) {
        obligatorio = newObligatorio;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Boolean getModificable() {
        return modificable;
    }

    /**
     * DOCUMENT ME!
     *
     * @param newModificable - DOCUMENT ME!
     */
    public void setModificable(Boolean newModificable) {
        modificable = newModificable;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getValorDefecto() {
        return valorDefecto;
    }

    /**
     * DOCUMENT ME!
     *
     * @param newValorDefecto - DOCUMENT ME!
     */
    public void setValorDefecto(String newValorDefecto) {
        valorDefecto = newValorDefecto;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getTipoCliente() {
        return tipoCliente;
    }

    /**
     * DOCUMENT ME!
     *
     * @param newTipoCliente - DOCUMENT ME!
     */
    public void setTipoCliente(String newTipoCliente) {
        tipoCliente = newTipoCliente;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public String getSubtipoCliente() {
        return subtipoCliente;
    }

    /**
     * DOCUMENT ME!
     *
     * @param newSubtipoCliente - DOCUMENT ME!
     */
    public void setSubtipoCliente(String newSubtipoCliente) {
        subtipoCliente = newSubtipoCliente;
    }

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     */
    public Boolean getIndClienteProducto() {
        return indClienteProducto;
    }

    /**
     * DOCUMENT ME!
     *
     * @param newIndClienteProducto - DOCUMENT ME!
     */
    public void setIndClienteProducto(Boolean newIndClienteProducto) {
        indClienteProducto = newIndClienteProducto;
    }
}
