/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Vector;

public class DTOTipoCajaProducto extends DTOSiccPaginacion {    
    private Long oid;
    private String codigoCaja;
    private String descripcion;
    private Vector attriTraducible; // descripcion
    
    
    public DTOTipoCajaProducto() {
        
    }
    
    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setCodigoCaja(String codigoCaja) {
        this.codigoCaja = codigoCaja;
    }

    public String getCodigoCaja() {
        return codigoCaja;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setAttriTraducible(Vector attriTraducible) {
        this.attriTraducible = attriTraducible;
    }

    public Vector getAttriTraducible() {
        return attriTraducible;
    }

}