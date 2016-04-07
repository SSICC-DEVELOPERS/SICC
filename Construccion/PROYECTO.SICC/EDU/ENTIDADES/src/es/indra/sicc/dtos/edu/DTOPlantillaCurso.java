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

import java.util.ArrayList;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOPlantillaCurso extends DTOSiccPaginacion {

    private String nombre;
    private ArrayList detalles;
    private Long oid;
    private DTOI18nSICC attriTraducible[];

    public DTOPlantillaCurso(){
        super();
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String newNombre){
        this.nombre = newNombre;
    }

    public ArrayList getDetalles(){
        return this.detalles;
    }

    public void setDetalles(ArrayList newDetalles){
        this.detalles = newDetalles;
    }

    public Long getOid(){
        return this.oid;
    }

    public void setOid(Long newOid){
        this.oid = newOid;
    }

    public DTOI18nSICC[] getAttriTraducible(){
        return this.attriTraducible;
    }

    public void setAttriTraducible(DTOI18nSICC newAttriTraducible[]){
        this.attriTraducible = newAttriTraducible;
    }
}