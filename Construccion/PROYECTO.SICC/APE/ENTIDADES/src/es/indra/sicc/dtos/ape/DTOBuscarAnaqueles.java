/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOBuscarAnaqueles extends DTOBelcorp {
    private Long oidMapaCDCabecera;
    private Long oidSublinea;
    
    public DTOBuscarAnaqueles() {
    }

    public void setOidMapaCDCabecera(Long oidMapaCDCabecera) {
        this.oidMapaCDCabecera = oidMapaCDCabecera;
    }

    public Long getOidMapaCDCabecera() {
        return oidMapaCDCabecera;
    }

    public void setOidSublinea(Long oidSublinea) {
        this.oidSublinea = oidSublinea;
    }

    public Long getOidSublinea() {
        return oidSublinea;
    }
}