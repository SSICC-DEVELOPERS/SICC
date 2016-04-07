/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.dtos.edu;

public class DTOParametro extends es.indra.sicc.util.DTOBelcorp {

    private String nombre;
    private Integer tipo;
    private String nombreTabla;
    private String tipoDato;
    private Long oid;

    public DTOParametro() {
        super();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String newNombre) {
        this.nombre = newNombre;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer newTipo) {
        this.tipo = newTipo;
    }

    public String getNombreTabla() {
        return this.nombreTabla;
    }

    public void setNombreTabla(String newNombreTabla) {
        this.nombreTabla = newNombreTabla;
    }

    public String getTipoDato() {
        return this.tipoDato;
    }

    public void setTipoDato(String newTipoDato) {
        this.tipoDato = newTipoDato;
    }

    public Long getOid() {
        return this.oid;
    }

    public void setOid(Long newOid) {
        this.oid = newOid;
    }
}