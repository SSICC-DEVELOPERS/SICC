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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

/**
 * Sistema:         Belcorp
 * Modulo:          MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:           07/1/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Viviana Bongiovanni
 */

public class DTOCombosImpuestos extends DTOAuditableSICC  {
    private RecordSet tasasImpuestos;
    private RecordSet canales;
    private RecordSet accesos;
    private RecordSet subaccesos;

    public DTOCombosImpuestos() {
    }

    public RecordSet getTasasImpuestos() {
        return tasasImpuestos;
    }

    public void setTasasImpuestos(RecordSet newTasasImpuestos) {
        tasasImpuestos = newTasasImpuestos;
    }

    public RecordSet getCanales() {
        return canales;
    }

    public void setCanales(RecordSet newCanales) {
        canales = newCanales;
    }

     public RecordSet getAccesos() {
        return accesos;
    }

    public void setAccesos(RecordSet newAccesos) {
        accesos = newAccesos;
    }

     public RecordSet getSubaccesos() {
        return subaccesos;
    }

    public void setSubaccesos(RecordSet newSubaccesos) {
        subaccesos = newSubaccesos;
    }
}