/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Subm�dulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           08/1/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Viviana Bongiovanni
 */

public class DTOModificarImpuesto  extends DTOAuditableSICC  {
    private Long oid;
    private Long impuesto;

    public DTOModificarImpuesto() {
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(Long newImpuesto) {
        impuesto = newImpuesto;
    }
}