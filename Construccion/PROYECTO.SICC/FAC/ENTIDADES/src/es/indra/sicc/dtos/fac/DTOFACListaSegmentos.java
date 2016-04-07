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


package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOFACListaSegmentos extends DTOBelcorp {

    public DTOFACListaSegmentos() {
    }

    private ArrayList listaSegmentos;

    public ArrayList getListaSegmentos() {
        return listaSegmentos;
    }

    public void setListaSegmentos(ArrayList newListaSegmentos) {
        listaSegmentos = newListaSegmentos;
    }
}