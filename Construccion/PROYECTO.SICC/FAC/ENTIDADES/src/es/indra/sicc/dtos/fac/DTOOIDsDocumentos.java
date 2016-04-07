/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;

public class DTOOIDsDocumentos extends DTOBelcorp  {
    private DTOOIDs lista;
    private Long subacceso;

    public DTOOIDsDocumentos() {
    }

    public DTOOIDs getLista() {
        return lista;
    }

    public void setLista(DTOOIDs lista) {
        this.lista = lista;
    }

    public Long getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(Long subacceso) {
        this.subacceso = subacceso;
    }
}