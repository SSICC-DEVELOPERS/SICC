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

import es.indra.sicc.util.DTOBelcorp;
import java.util.Vector;

public class DTOSistemaEtiquetado extends DTOBelcorp {
    private Long oid;
    private String codigo;
    private String descripcion;
    private Vector atriTraducible; // descripcion i18n
    
    
    public DTOSistemaEtiquetado() {
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setAtriTraducible(Vector atriTraducible) {
        this.atriTraducible = atriTraducible;
    }

    public Vector getAtriTraducible() {
        return atriTraducible;
    }
    
}