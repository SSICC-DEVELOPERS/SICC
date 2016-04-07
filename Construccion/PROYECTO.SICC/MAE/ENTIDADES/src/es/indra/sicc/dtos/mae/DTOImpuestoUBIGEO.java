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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

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

public class DTOImpuestoUBIGEO extends DTOSiccPaginacion  {
    private String material;
    private Long tasaImpuesto;
    private Long subacceso;
    private Long canal;
    private Long acceso;

    public DTOImpuestoUBIGEO() {
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String newMaterial) {
        material = newMaterial;
    }

    public Long getTasaImpuesto() {
        return tasaImpuesto;
    }

    public void setTasaImpuesto(Long newTasaImpuesto) {
        tasaImpuesto = newTasaImpuesto;
    }

    public Long getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(Long newSubacceso) {
        subacceso = newSubacceso;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long newAcceso) {
        acceso = newAcceso;
    }
}