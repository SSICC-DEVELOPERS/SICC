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
 * Fecha:           19/1/2004
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Viviana Bongiovanni
 */

public class DTOProductoKit extends DTOAuditableSICC  {
    private Long oidProducto;
    private Integer numUnidades;
    private String producto;

    public DTOProductoKit() {
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long newOidProducto) {
        oidProducto = newOidProducto;
    }

    public Integer getNumUnidades() {
        return numUnidades;
    }

    public void setNumUnidades(Integer newNumUnidades) {
        numUnidades = newNumUnidades;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String newProducto) {
        producto = newProducto;
    }
}