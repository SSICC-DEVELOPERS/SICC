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
package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           13/02/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Matias Dolce
 */

public class DTOBusquedaKit extends DTOSiccPaginacion  {
    private String codSAP;
    private String codAntiguo;
    private String descCorta;
    private String descSAP;

    public DTOBusquedaKit() {
    }

    public String getCodSAP() {
        return codSAP;
    }

    public void setCodSAP(String newcodSAP) {
        codSAP = newcodSAP;
    }

    public String getCodAntiguo() {
        return codAntiguo;
    }

    public void setCodAntiguo(String newcodAntiguo) {
        codAntiguo = newcodAntiguo;
    }

    public String getDescCorta() {
        return descCorta;
    }

    public void setDescCorta(String newdescCorta) {
        descCorta = newdescCorta;
    }

      public String getDescSAP() {
        return descSAP;
    }

    public void setDescSAP(String newdescSAP) {
        descSAP = newdescSAP;
    }
}
